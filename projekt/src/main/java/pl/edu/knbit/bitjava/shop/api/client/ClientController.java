package pl.edu.knbit.bitjava.shop.api.client;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.knbit.bitjava.shop.domain.client.Address;
import pl.edu.knbit.bitjava.shop.domain.client.Client;
import pl.edu.knbit.bitjava.shop.domain.client.ClientStorage;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientStorage clientStorage;

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(clientStorage.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(clientStorage.findById(id));
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody @Valid CreateClientRequest request) {
        return ResponseEntity.ok(clientStorage.createOrUpdateClient(request.toClient()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable UUID id,
                                               @RequestBody @Valid UpdateClientRequest request) {

        final Client client = clientStorage.findById(id);
        client.setEmail(request.getEmail());
        client.setAddress(request.getAddress() != null ? request.getAddress() : client.getAddress());

        return ResponseEntity.ok(clientStorage.createOrUpdateClient(client));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable UUID id) {
        clientStorage.removeClient(id);
    }

    @Data
    static class CreateClientRequest {

        @NotNull
        private String firstName;

        @NotNull
        private String lastName;

        @NotNull
        @Pattern(regexp = ".*@.*")
        private String email;

        @NotNull
        private Address address;

        Client toClient() {
            return new Client(
                    this.firstName,
                    this.lastName,
                    this.email,
                    this.address
            );
        }

    }

    @Data
    static class UpdateClientRequest {

        @NotNull
        @Pattern(regexp = ".*@.*")
        private String email;

        private Address address;

    }

}

package pl.edu.knbit.bitjava.shop.api.client;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.knbit.bitjava.shop.commom.exception.NotFoundException;
import pl.edu.knbit.bitjava.shop.domain.client.Address;
import pl.edu.knbit.bitjava.shop.domain.client.Client;
import pl.edu.knbit.bitjava.shop.domain.client.ClientStorage;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientStorage clientStorage;

    @GetMapping
    public List<ClientResponse> findAll() {
        return clientStorage.findAll()
                .stream()
                .map(ClientResponse::fromClient)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClientResponse findById(@PathVariable UUID id) {
        final Client client = clientStorage
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Client with given ID does not exist"));

        return ClientResponse.fromClient(client);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse createClient(@RequestBody @Valid CreateClientRequest request) {
        final Client newClient = clientStorage.createOrUpdateClient(request.toClient());

        return ClientResponse.fromClient(newClient);
    }

    @PutMapping("/{id}")
    public ClientResponse updateClient(@PathVariable UUID id,
                                       @RequestBody @Valid UpdateClientRequest request) {

        final Client client = clientStorage
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Client with given ID does not exist"));

        client.setEmail(request.getEmail());
        client.setAddress(request.getAddress() != null ? request.getAddress() : client.getAddress());

        return ClientResponse.fromClient(clientStorage.createOrUpdateClient(client));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable UUID id) {
        clientStorage.removeClient(id);
    }

    @Data
    @Builder
    static class ClientResponse {

        private UUID id;
        private String firstName;
        private String lastName;
        private String email;
        private Address address;
        private Long invoices;

        static ClientResponse fromClient(Client client) {
            return ClientResponse.builder()
                    .id(client.getId())
                    .firstName(client.getFirstName())
                    .lastName(client.getLastName())
                    .email(client.getLastName())
                    .address(client.getAddress())
                    .invoices((long) client.getInvoices().size())
                    .build();
        }

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

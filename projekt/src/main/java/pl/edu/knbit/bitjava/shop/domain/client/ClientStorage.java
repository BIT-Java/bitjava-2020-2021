package pl.edu.knbit.bitjava.shop.domain.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.knbit.bitjava.shop.commom.exception.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientStorage {

    private final ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findById(UUID id) {
        return clientRepository.findById(id);
    }

    public List<Client> findByCity(String city) {
        return clientRepository.findByAddress_City(city);
    }

    public Client createOrUpdateClient(Client client) {
        return clientRepository.save(client);
    }

    public void removeClient(UUID id) {
        clientRepository.deleteById(id);
    }

}

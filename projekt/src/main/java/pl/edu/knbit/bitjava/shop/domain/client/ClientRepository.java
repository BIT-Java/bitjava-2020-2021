package pl.edu.knbit.bitjava.shop.domain.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    List<Client> findByAddress_City(String city);
    void deleteById(UUID id);
    Optional<Client> findClientByEmail(String email);
}

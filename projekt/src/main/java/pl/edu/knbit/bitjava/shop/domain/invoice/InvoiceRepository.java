package pl.edu.knbit.bitjava.shop.domain.invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.knbit.bitjava.shop.domain.client.Client;

import java.util.List;
import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {

    List<Invoice> findAllByClient(Client client);

}

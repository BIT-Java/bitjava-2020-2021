package pl.edu.knbit.bitjava.shop.domain.invoice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceProductRepository extends JpaRepository<InvoiceProduct, UUID> {

}

package pl.edu.knbit.bitjava.shop.domain.invoice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.knbit.bitjava.shop.domain.client.Client;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceStorage {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceProductRepository invoiceProductRepository;

    public List<Invoice> findByClient(Client client) {
        return invoiceRepository.findAllByClient(client);
    }

    public Invoice createOrUpdate(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

}

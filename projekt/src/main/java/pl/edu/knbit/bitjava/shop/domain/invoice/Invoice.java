package pl.edu.knbit.bitjava.shop.domain.invoice;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.edu.knbit.bitjava.shop.domain.client.Client;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "INVOICES")
@RequiredArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private Instant timeCreated;

    @Enumerated(EnumType.STRING)
    private InvoiceType invoiceType;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceProduct> products;

    public Invoice(InvoiceType invoiceType, List<InvoiceProduct> products) {
        this.invoiceType = invoiceType;
        this.products = products;
    }

}

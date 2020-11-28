package pl.edu.knbit.bitjava.shop.domain.invoice;

import lombok.*;
import pl.edu.knbit.bitjava.shop.domain.client.Client;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "INVOICES")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private Instant timeCreated = Instant.now();

    @Enumerated(EnumType.STRING)
    private InvoiceType invoiceType;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceProduct> products;

}

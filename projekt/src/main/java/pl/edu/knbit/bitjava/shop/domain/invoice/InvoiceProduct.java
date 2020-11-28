package pl.edu.knbit.bitjava.shop.domain.invoice;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.edu.knbit.bitjava.shop.domain.product.Product;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "INVOICE_PRODUCTS")
public class InvoiceProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Long amount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

}

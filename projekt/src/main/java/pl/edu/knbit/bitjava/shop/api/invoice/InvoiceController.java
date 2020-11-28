package pl.edu.knbit.bitjava.shop.api.invoice;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.knbit.bitjava.shop.commom.exception.NotFoundException;
import pl.edu.knbit.bitjava.shop.domain.client.Client;
import pl.edu.knbit.bitjava.shop.domain.client.ClientStorage;
import pl.edu.knbit.bitjava.shop.domain.invoice.Invoice;
import pl.edu.knbit.bitjava.shop.domain.invoice.InvoiceProduct;
import pl.edu.knbit.bitjava.shop.domain.invoice.InvoiceStorage;
import pl.edu.knbit.bitjava.shop.domain.invoice.InvoiceType;
import pl.edu.knbit.bitjava.shop.domain.product.Product;
import pl.edu.knbit.bitjava.shop.domain.product.ProductStorage;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients/{clientId}/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceStorage invoiceStorage;
    private final ClientStorage clientStorage;
    private final ProductStorage productStorage;

    @GetMapping
    public List<InvoiceResponse> findAll(@PathVariable UUID clientId) {
        final Client client = clientStorage
                .findById(clientId)
                .orElseThrow(() -> new NotFoundException("Client with given ID does not exist"));

        return invoiceStorage.findByClient(client)
                .stream()
                .map(InvoiceResponse::fromInvoice)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceResponse createInvoice(@PathVariable UUID clientId,
                                         @RequestBody @Valid CreateInvoiceRequest request) {

        final Client client = clientStorage
                .findById(clientId)
                .orElseThrow(() -> new NotFoundException("Client with given ID does not exist"));

        final Invoice invoice = Invoice.builder()
                .invoiceType(request.getType())
                .timeCreated(Instant.now())
                .client(client)
                .products(request.getProducts()
                        .stream()
                        .map(p -> {
                                    Product product = productStorage
                                            .findById(p.getId())
                                            .orElseThrow(() -> new NotFoundException("Product with given ID does not exist"));

                                    return InvoiceProduct.builder()
                                            .product(product)
                                            .amount(p.getAmount())
                                            .build();
                                }
                        )
                        .collect(Collectors.toList()))
                .build();

        return InvoiceResponse.fromInvoice(invoiceStorage.createOrUpdate(invoice));
    }

    @Data
    @Builder
    static class InvoiceResponse {

        private Instant timeCreated;
        private InvoiceType invoiceType;
        private List<InvoiceProductResponse> products;

        static InvoiceResponse fromInvoice(Invoice invoice) {
            return InvoiceResponse.builder()
                    .timeCreated(invoice.getTimeCreated())
                    .invoiceType(invoice.getInvoiceType())
                    .products(invoice.getProducts()
                            .stream()
                            .map(InvoiceProductResponse::fromInvoiceProduct)
                            .collect(Collectors.toList())
                    )
                    .build();
        }

    }

    @Data
    @Builder
    static class InvoiceProductResponse {

        private UUID id;
        private String name;
        private Long amount;

        static InvoiceProductResponse fromInvoiceProduct(InvoiceProduct product) {
            return InvoiceProductResponse.builder()
                    .id(product.getProduct().getId())
                    .name(product.getProduct().getName())
                    .amount(product.getAmount())
                    .build();
        }

    }

    @Data
    static class CreateInvoiceRequest {

        @NotNull
        private final InvoiceType type;

        @NotNull
        private final List<CreateInvoiceProduct> products;

        Invoice toInvoice() {
            return Invoice.builder()
                    .invoiceType(type)
                    .build();
        }

    }

    @Data
    static class CreateInvoiceProduct {

        private final UUID id;
        private final Long amount;

    }

}

package pl.edu.knbit.bitjava.shop.domain.client;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.knbit.bitjava.shop.domain.invoice.Invoice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "CLIENTS")
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    @Embedded
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private List<Invoice> invoices = new ArrayList<>();

    public Client(String firstName, String lastName, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

}

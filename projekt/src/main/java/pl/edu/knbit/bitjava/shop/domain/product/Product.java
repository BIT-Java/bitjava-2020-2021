package pl.edu.knbit.bitjava.shop.domain.product;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by surja on 23.11.2020
 */

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;

    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    public Product(String name, ProductCategory productCategory) {
        this.name = name;
        this.productCategory = productCategory;
    }

}

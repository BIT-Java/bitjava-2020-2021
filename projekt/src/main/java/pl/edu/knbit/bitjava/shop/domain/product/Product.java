package pl.edu.knbit.bitjava.shop.domain.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by surja on 23.11.2020
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;

    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    public Product(String name, ProductCategory productCategory) {
        this.name = name;
        this.productCategory = productCategory;
    }

}

package pl.edu.knbit.bitjava.shop.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

/**
 * Created by surja on 23.11.2020
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();
}

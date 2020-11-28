package pl.edu.knbit.bitjava.shop.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findByProductCategory(ProductCategory productCategory);
    void deleteById(UUID id);

}

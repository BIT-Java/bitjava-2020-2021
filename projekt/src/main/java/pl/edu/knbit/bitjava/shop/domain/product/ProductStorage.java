package pl.edu.knbit.bitjava.shop.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductStorage {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id);
    }

    public List<Product> findByCategory(ProductCategory productCategory) {
        return productRepository.findByProductCategory(productCategory);
    }

    public Product createOrUpdate(Product product) {
        return productRepository.save(product);
    }

    public void removeById(UUID id) {
        productRepository.deleteById(id);
    }

}

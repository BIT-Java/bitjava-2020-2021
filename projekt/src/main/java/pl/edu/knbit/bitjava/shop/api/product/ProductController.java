package pl.edu.knbit.bitjava.shop.api.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.knbit.bitjava.shop.commom.exception.NotFoundException;
import pl.edu.knbit.bitjava.shop.domain.product.Product;
import pl.edu.knbit.bitjava.shop.domain.product.ProductCategory;
import pl.edu.knbit.bitjava.shop.domain.product.ProductStorage;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductStorage productStorage;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productStorage.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable UUID id) {
        Product product = productStorage.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with given ID does not exist"));

        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid CreateProductRequest request) {
        final Product newProduct = productStorage.createOrUpdate(request.toProduct());

        return ResponseEntity.ok(newProduct);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable UUID id) {
        productStorage.removeById(id);
    }

    static class CreateProductRequest {

        @NotNull
        private String name;

        @NotNull
        private ProductCategory productCategory;

        Product toProduct() {
            return new Product(this.name, this.productCategory);
        }

    }

}

package pl.edu.knbit.bitjava.shop.api.product;

import lombok.Builder;
import lombok.Data;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductStorage productStorage;

    @GetMapping
    public List<ProductResponse> findAll() {
        return productStorage.findAll()
                .stream()
                .map(ProductResponse::fromProduct)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable UUID id) {
        Product product = productStorage.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with given ID does not exist"));

        return ProductResponse.fromProduct(product);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody @Valid CreateProductRequest request) {
        final Product newProduct = productStorage.createOrUpdate(request.toProduct());

        return ProductResponse.fromProduct(newProduct);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable UUID id) {
        productStorage.removeById(id);
    }


    @Data
    @Builder
    static class ProductResponse {

        private UUID id;
        private String name;
        private ProductCategory category;

        static ProductResponse fromProduct(Product product) {
            return ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .category(product.getProductCategory())
                    .build();
        }

    }

    @Data
    static class CreateProductRequest {

        @NotNull
        private String name;

        @NotNull
        private ProductCategory category;

        Product toProduct() {
            return new Product(this.name, this.category);
        }

    }

}

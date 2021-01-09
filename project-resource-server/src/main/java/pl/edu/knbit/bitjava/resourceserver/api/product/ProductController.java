package pl.edu.knbit.bitjava.resourceserver.api.product;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<ProductResponse> getProducts() {
        return Arrays.asList(
                new ProductResponse(UUID.randomUUID(), "Apple"),
                new ProductResponse(UUID.randomUUID(), "Orange"),
                new ProductResponse(UUID.randomUUID(), "Banana")
        );
    }

    @Data
    private static class ProductResponse {

        private final UUID id;
        private final String name;

    }

}

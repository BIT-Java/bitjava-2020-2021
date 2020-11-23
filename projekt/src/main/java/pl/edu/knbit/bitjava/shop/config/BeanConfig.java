package pl.edu.knbit.bitjava.shop.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.knbit.bitjava.shop.model.Cart;
import pl.edu.knbit.bitjava.shop.model.Category;
import pl.edu.knbit.bitjava.shop.model.Product;
import pl.edu.knbit.bitjava.shop.model.User;
import pl.edu.knbit.bitjava.shop.repositories.UserRepository;

import java.util.*;

/**
 * Created by surja on 23.11.2020
 */
@Configuration
public class BeanConfig {

    private UserRepository userRepository;

    public BeanConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Product apple = Product.builder().category(Category.FOOD).name("Apple").build();
            Product laptop = Product.builder().category(Category.RTV_AGD).name("Laptop").build();
            Cart cart = Cart.builder().productList(List.of(apple, laptop)).build();
            User user = User.builder().name("Alicja").cart(cart).build();
            userRepository.save(user);
        };
    }
}

package pl.edu.knbit.bitjava.rozwiazania;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by surja on 01.11.2020
 */
public class Cart {
    private List<Product> productList = new ArrayList<>();

    public void addToCart(Product product) {
        this.productList.add(product);
    }

    public Double getPrice() {
        //without streams
//        double price = 0;
//        for (Product product : productList) {
//            price += product.getPrice();
//        }
//        return price;

        //java streams
        return productList.stream()
                .map(Product::getPrice)
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public void clearCart() {
        this.productList.removeAll(this.productList);
    }

    public List<Product> getSortedProducts() {
        return this.productList.stream().sorted().collect(Collectors.toList());
    }

    public List<Product> getSortedProductsBy(Comparator<Product> comparator) {
        return this.productList.stream().sorted(comparator).collect(Collectors.toList());
    }
}

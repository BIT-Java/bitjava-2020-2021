package pl.edu.knbit.bitjava.rozwiazania;

import java.util.List;

/**
 * Created by surja on 01.11.2020
 */
public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addToCart(new Phone("Iphone", 3200.99D, "12"));
        cart.addToCart(new Phone("Samsung", 2000D, "Galaxy S8"));
        cart.addToCart(new TV("LG", 5000D, 55));
        cart.addToCart(new TV("Sony", 2500D, 42));

        Double price = cart.getPrice();
        System.out.println(price);
//        cart.pay();
        Double price2 = cart.getPrice();
        System.out.println(price2);
        List<Product> sortedProducts = cart.getSortedProducts();
        System.out.println(sortedProducts);

        List<Product> sortedProductsByName = cart.getSortedProductsBy(new ProductNameComparator());
        System.out.println(sortedProductsByName);
    }
}

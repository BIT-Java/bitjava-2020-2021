package pl.edu.knbit.bitjava.rozwiazania;

/**
 * Created by surja on 01.11.2020
 */
public interface Product extends Comparable<Product> {
    double getPrice();

    String getName();

    //w nowszych Javach interface'y mogą mieć defaultowe implementacje metod
    @Override
    default int compareTo(Product o) {
        return (int) (this.getPrice() - o.getPrice());
    }
}

package pl.edu.knbit.bitjava.rozwiazania;

import java.util.Comparator;

/**
 * Created by surja on 01.11.2020
 */
public class ProductNameComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

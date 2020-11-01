package pl.edu.knbit.bitjava.rozwiazania;

/**
 * Created by surja on 01.11.2020
 */
public class TV implements Product {
    private String name;
    private double price;
    private int inches;

    public TV(String name, double price, int inches) {
        this.name = name;
        this.price = price;
        this.inches = inches;
    }

    public int getScreenSize(){
        return this.inches;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "TV{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", inches=" + inches +
                '}';
    }
}

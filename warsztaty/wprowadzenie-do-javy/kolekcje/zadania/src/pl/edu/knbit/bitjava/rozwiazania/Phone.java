package pl.edu.knbit.bitjava.rozwiazania;

/**
 * Created by surja on 01.11.2020
 */
public class Phone implements Product {
    private String name;
    private double price;
    private String model;

    public Phone(String name, double price, String model) {
        this.name = name;
        this.price = price;
        this.model = model;
    }

    public String getMode() {
        return model;
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
        return "Phone{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", model='" + model + '\'' +
                '}';
    }
}

package pl.edu.knbit.bitjava.rozwiazania;

import java.util.Optional;

/**
 * Created by surja on 01.11.2020
 */
public class Address {
    public String street;
    public String city;
    public String country;

    public Address(String country) {
        this.country = country;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Optional<String> getStreet() {
        return Optional.ofNullable(street);
    }

    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }

    public Optional<String> getCountry() {
        return Optional.ofNullable(country);
    }
}

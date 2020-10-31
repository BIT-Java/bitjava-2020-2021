package pl.edu.knbit.bitjava;

import java.util.Optional;

/**
 * Created by surja on 31.10.2020
 */
public class User {
    public String firstName;
    public int age;
    public Address address;

    public User(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }
}

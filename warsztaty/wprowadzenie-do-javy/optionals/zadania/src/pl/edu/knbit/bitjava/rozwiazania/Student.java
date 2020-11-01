package pl.edu.knbit.bitjava.rozwiazania;

import java.util.Optional;

/**
 * Created by surja on 01.11.2020
 */
public class Student {
    private Long id;
    private String name;
    private Address address;

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }
}

package pl.edu.knbit.bitjava.ex2;

import java.util.*;

/**
 * Created by surja on 31.10.2020
 */
public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Audi("RS7"));
        cars.add(new Mercedes("A45-AMG"));

        for (Car car : cars) {
            if(car instanceof Audi)
                car.speedUp(10);
            else if(car instanceof Mercedes)
                car.speedUp(5);

            System.out.println(car.getSpeed());
        }

    }
}

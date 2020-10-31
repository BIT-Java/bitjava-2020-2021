package pl.edu.knbit.bitjava.ex2;

/**
 * Created by surja on 31.10.2020
 */
public class Mercedes implements Car {
    private String model;
    private Integer speed = 0;

    public Mercedes(String model) {
        this.model = model;

    }

    @Override
    public void speedUp(int increment) {
        System.out.println("Incrementing speed for Mercedes");
        this.speed += increment;
    }

    @Override
    public Integer getSpeed() {
        return this.speed;
    }
}

package pl.edu.knbit.bitjava.lab1.interfaces;

import pl.edu.knbit.bitjava.lab1.interfaces.figures.Cube;
import pl.edu.knbit.bitjava.lab1.interfaces.figures.Figure;
import pl.edu.knbit.bitjava.lab1.interfaces.figures.Square;
import pl.edu.knbit.bitjava.lab1.interfaces.figures.Triangle;

public class Main {

    public static void main(String[] args) {
        Figure[] figures = {
                new Cube(),
                new Triangle(),
                new Triangle(),
                new Square()
        };

        for(Figure figure : figures) {
            figure.fill("white");
        }

        Triangle triangle = (Triangle) figures[1];
        triangle.rotate(20);

    }

}

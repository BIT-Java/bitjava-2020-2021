package pl.edu.knbit.bitjava.lab1.interfaces.figures;

public class Triangle extends Base2DFigure {

    @Override
    public void fill(String color) {
        System.out.println("Filled triangle with " + color);
    }

    public void rotate(int angle) {
        System.out.println("Rotated triangle for " + angle + " degrees");
    }

}

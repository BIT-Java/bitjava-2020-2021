package pl.edu.knbit.bitjava.lab1.interfaces.figures;

public class Cube extends Base3DFigure {

    @Override
    public void fill(String color) {
        System.out.println("Filled cube with " + color);
    }
}

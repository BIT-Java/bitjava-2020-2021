package pl.edu.knbit.bitjava.lab1.interfaces.figures;

public class Square extends Base2DFigure {

    @Override
    public void fill(String color) {
        System.out.println("Filled square with " + color);
    }

}

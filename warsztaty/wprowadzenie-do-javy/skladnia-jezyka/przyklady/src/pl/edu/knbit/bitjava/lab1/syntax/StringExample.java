package pl.edu.knbit.bitjava.lab1.syntax;

public class StringExample {

    public static void main(String[] args) {
        String s = "BIT Java";
        String s2 = s.substring(0, 3);

        String s3 = s2 + s;

        System.out.println(s2);
        System.out.println(s3);

        s.equals(s3);

        int a = 10;
        int b = 5;

    }

}

package pl.edu.knbit.bitjava.lab1.syntax;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // metoda main - od niej zawsze rozpoczyna sie program
    public static void main(String[] args) {

        // typy podstawowe:
        final int a = 1;
        short b = 1;
        long c = 174921;
        byte d = 24;

        double e = 10.21D;
        float f = 123.1F;
        char g = 'c';

        boolean h = true;


        // slowo kluczowe final:
        final int someVariable = 10;


        // operatory arytmetyczne:
        int a1 = 20, a2 = 5;

        int a3 = a1 + a2; // a3 = 25
        int a4 = a1 - a2; // a4 = 15
        int a5 = a1 * a2; // a5 = 100
        int a6 = a1 / a2; // a6 = 4

        int a7 = a2 % a6; // a7 = 1


        // operatory logiczne:
        boolean b1 = true, b2 = false;

        boolean b3 = b1 || b2; // b3 = b1 OR b2
        boolean b4 = b1 && b2; // b4 = b1 AND b2
        boolean b5 = !b1;      // b5 = NOT b1


        // operatory relacyjne:
        boolean c1 = a1 > a2;  // c1 = true
        boolean c2 = a1 >= a2; // c2 = true
        boolean c3 = a1 == a2; // c3 = false
        boolean c4 = a1 != a2; // c4 = false


        // operatory inkrementacji/dekrementacji:
        a1++;
        ++a1;
        a1--;
        --a1;

        // rzutowanie:
        double x = 9.992;
        int y = (int) x; // y = 9


        // komentarze:

        // to jest pojedynczy komentarz

        /*
        ten komentarz
        ma zasieg
        wielu linii
         */


        // String:
        String s = "BIT Java";
        String s2 = s.substring(0, 3); // s2 = BIT

        String anotherString = "Java";
        boolean stringsAreEqual = s.equals(anotherString);

        String s3 = "BIT";
        String s4 = "BIT";
        String s5 = "BIT Java".substring(0, 3);

        boolean s34 = s3 == s4;
        boolean s35 = s3 == s5;
        System.out.println(s34);
        System.out.println(s35);

        StringBuilder sb = new StringBuilder();
        sb.append("BIT").append(" ").append("Java").append(" ").append(2020);
        System.out.println(sb.toString());


        // bloki i zasieg zmiennych:
        int n = 5;

        {
            int k = 10;
            // int n = 20; błąd!
        }

        int k = 15; // tu nie ma błędu :d


        // if-else:
        boolean result = true;

        // some code here...

        if (result) {
            // code if result is true
        } else {
            // code if result iis false
        }


        // pętla while:
        int step = 1;
        int sum = 0;

        while (step <= 5) {
            sum += (step * 2);
            step++;
        }

        System.out.println("step: " + step + ", sum: " + sum); // sum = 1*2 + 2*2 + 3*2 + 4*2 + 5*2 = 30


        // pętla do-while:
        int i = 0;

        do {
            System.out.println("i: " + i);
            i++;
        } while (i < 10);


        // pętla for:
        for (int j = 0; j < 10; j++) {
            System.out.println("i: " + i);
        }


        // pętla for-each:
        int[] tab = {1, 2, 3, 4};
        for (int value : tab) {
            System.out.println("value: " + value);
        }


        // switch:
        Direction direction = Direction.SOUTH;

        switch (direction) {
            case NORTH:
                System.out.println("N");
                break;
            case WEST:
                System.out.println("W");
                break;
            case EAST:
                System.out.println("E");
                break;
            case SOUTH:
                System.out.println("S");
                break;
        }


        // switch - nowy sposób:
        switch (direction) {
            case NORTH -> System.out.println("N");
            case EAST -> System.out.println("E");
            case WEST -> {
                System.out.println("W");
                System.out.println("W");
            }
            case SOUTH -> System.out.println("S");
        }


        // switch - jeszcze więcej możliwości:
        String directionName = switch (direction) {
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
            case NORTH -> {
                String name = "North";
                name = name.substring(0, 1);

                yield name;
            }
        };


        // tablice:
        int[] tab1 = {1, 2, 3, 4};
        int[] tab2 = new int[4]; // tab2 = {0, 0, 0, 0}

        int v1 = tab1[2];

        Arrays.equals(tab1, tab2);
        int[] tab3 = Arrays.copyOf(tab1, tab1.length);


        // tablice wielowymiarowe:

        // 0 0 0
        // 0 0 0
        int[][][] tab4 = new int[2][3][9];
        int[][] tab5 = {{1, 2, 3}, {4, 5, 6}};

        int v2 = tab5[1][1];
        System.out.println(v2);


        // Scanner:
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbe:");
        int input = scanner.nextInt();
        System.out.println("Liczba: " + input);

    }

}

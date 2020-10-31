package pl.edu.knbit.bitjava;

import java.util.*;

/**
 * Created by surja on 31.10.2020
 */
public class Main {
    public static void main(String[] args) {
//        ArrayList<Student> studentList = new ArrayList<>();
//        apply(studentList);
//        apply2(studentList);
//
//        HashSet<Student> hashSet = new HashSet<>();
//        apply(hashSet);
//        apply2(hashSet);

        List<Student> students = new ArrayList<>(Arrays.asList(new Student("Jan", "Nowak", 12), new Student("Kasia", "Kowalska", 22)));

        students.add(new Student("Adam", "Mickiewicz", 21));
        System.out.println(students.size());
        Student student = students.remove(1);
        System.out.println(student);
        System.out.println(students.size());

//        students.clear();
//        System.out.println(students.size());
        students.removeIf(student1 -> student1.age < 15);
        System.out.println(students.size());

        //contains
        boolean contains = students.contains(new Student("Adam", "Mickiewicz", 21));
        System.out.println(contains);

//sort
        List<Student> list = new ArrayList<>(Arrays.asList(
                new Student("Jan", "Nowak", 12), new Student("Kasia", "Kowalska", 22), new Student("Adam", "Mickiewicz", 21)));
//        list.sort(new StudentAgeComparator());
//        for (Student student1 : list) {
//            System.out.println(student1);
//        }

        Collections.sort(list, Collections.reverseOrder());
        for (Student student1 : list) {
            System.out.println(student1);
        }

    }

    private static void apply(Collection<Student> collection) {
        //code
    }

    private static void apply2(List<Student> collection) {
        //code
    }
}

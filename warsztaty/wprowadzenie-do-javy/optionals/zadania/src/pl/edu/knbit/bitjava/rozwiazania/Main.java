package pl.edu.knbit.bitjava.rozwiazania;

/**
 * Created by surja on 01.11.2020
 */
public class Main {
    public static void main(String[] args) {
        Address address = new Address("Polska");
        Student marek = new Student(1L, "Marek");
        Student kasia = new Student(2L, "Kasia");
        Student kamil = new Student(3L, "Kamil");

        Course course = new Course();
        course.addStudent(marek);
        course.addStudent(kasia);
        course.addStudent(kamil);

        String studentName = course.
                findStudent(1L)
                .map(student -> student.getName())
                .orElse("");
        System.out.println("Name of existing student: "+studentName);

        String studentName2 = course.
                findStudent(100L)
                .map(student -> student.getName())
                .orElse("");
        System.out.println("Name of nonexistent student: "+studentName2);

        marek.setAddress(address);
        String street = course.findStudent(1L)
                .flatMap(student -> student.getAddress())
                .flatMap(address1 -> address.getStreet())
                .orElse("");
        System.out.println("Nonexistent street: "+street);
        address.setStreet("Czarnowiejska");

        String street2 = course.findStudent(1L)
                .flatMap(student -> student.getAddress())
                .flatMap(address1 -> address.getStreet())
                .orElse("");
        System.out.println("Existing street: "+street2);


    }
}

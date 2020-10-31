package pl.edu.knbit.bitjava;

import java.util.Objects;

/**
 * Created by surja on 31.10.2020
 */
public class Student implements Comparable<Student> {
    public String firstName;
    public String lastName;
    public Integer age;

    public Student(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Student)) return false;
//        Student student = (Student) o;
//        return Objects.equals(firstName, student.firstName) &&
//                Objects.equals(lastName, student.lastName) &&
//                Objects.equals(age, student.age);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(firstName, lastName, age);
//    }
}

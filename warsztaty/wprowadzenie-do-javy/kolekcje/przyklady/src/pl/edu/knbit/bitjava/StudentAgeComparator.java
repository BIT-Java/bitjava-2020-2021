package pl.edu.knbit.bitjava;

import java.util.Comparator;

/**
 * Created by surja on 31.10.2020
 */
public class StudentAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}

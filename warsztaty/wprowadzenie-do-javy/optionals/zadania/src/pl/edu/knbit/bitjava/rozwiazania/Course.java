package pl.edu.knbit.bitjava.rozwiazania;

import java.util.*;

/**
 * Created by surja on 01.11.2020
 */
public class Course {
    private HashMap<Long, Student> studentMap = new HashMap<>();

    public void addStudent(Student student){
        this.studentMap.put(student.getId(), student);
    }

    public Optional<Student> findStudent(Long studentId){
        Student student = studentMap.get(studentId);
        return Optional.ofNullable(student);
    }
}

package pl.edu.knbit.bitjava.model;

import java.util.*;

/**
 * Created by surja on 31.10.2020
 */
public class Course{
    public String name;
    public List<Student> students;

    public Course(String name) {
        this.name = name;
        students = new ArrayList<>();
    }


    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}

package pl.edu.knbit.bitjava.rozwiazania;

import pl.edu.knbit.bitjava.rozwiazania.services.CourseService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by surja on 01.11.2020
 */
public class Main {
    public static void main(String[] args) {
        CourseService courseService = new CourseService();
        courseService.getCourses().stream()
                .map(course -> course.name)
                .forEach(System.out::println);

        courseService.getCourses().stream()
                .flatMap(course -> course.getStudents().stream())
                .forEach(student -> System.out.println(student.firstName));

        long count = courseService.getCourses().stream()
                .flatMap(course -> course.getStudents().stream())
                .distinct()
                .count();
        System.out.println(count);

        List<String> stringList = courseService.getCourses().stream()
                .flatMap(course -> course.getStudents().stream())
                .distinct()
                .filter(student -> student.age < 20)
                .map(student -> student.firstName)
                .collect(Collectors.toList());
        stringList.forEach(System.out::println);

        courseService.getCourses().stream()
                .flatMap(course -> course.getStudents().stream())
                .distinct()
                .sorted((s1, s2) -> s1.age-s2.age)
                .forEach(System.out::println);

    }
}

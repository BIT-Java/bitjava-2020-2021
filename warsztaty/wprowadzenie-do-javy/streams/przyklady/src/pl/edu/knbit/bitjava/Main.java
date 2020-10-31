package pl.edu.knbit.bitjava;

import pl.edu.knbit.bitjava.model.Course;
import pl.edu.knbit.bitjava.model.Student;
import pl.edu.knbit.bitjava.model.dto.CourseDTO;
import pl.edu.knbit.bitjava.services.CourseService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by surja on 31.10.2020
 */
public class Main {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 66, 1, 41, 2, 4, 14, 4, 6, 12, 6, 88, 4};
        CourseService courseService = new CourseService();

//        courseService.getCourses().forEach(course -> System.out.println(course));
//        courseService.getCourses().forEach(System.out::println);


//        Arrays.stream(ints).boxed().forEach(integer -> System.out.println(integer));
//
//        Arrays.stream(ints).boxed().filter(integer -> integer > 50).forEach(integer -> System.out.println(integer));
//        //COUNT
//        long count = Arrays.stream(ints).boxed().filter(integer -> integer > 50).count();
//        System.out.println(count);
//        //SORTED
//        Arrays.stream(ints).boxed().filter(integer -> integer < 50).sorted(Collections.reverseOrder()).forEach(System.out::println);
//
//        //ANY_MATCH
//        boolean b = Arrays.stream(ints).boxed().anyMatch(integer -> integer == 1);
//        System.out.println(b);
//        //ALL_MATCH
//        boolean b1 = Arrays.stream(ints).boxed().allMatch(integer -> integer == 1);
//        System.out.println(b1);

//        //takeWhile, dropWhile, distinct
//        Arrays.stream(ints).boxed().takeWhile(integer -> integer < 50).forEach(System.out::println);
//        Arrays.stream(ints).boxed().distinct().forEach(System.out::println);
//        Arrays.stream(ints).boxed().dropWhile(integer -> integer<50).forEach(System.out::println);

//        Arrays.stream(ints).boxed().skip(2).forEach(System.out::println);

//        int sum = Arrays.stream(ints).boxed().skip(2).mapToInt(Integer::intValue).sum();
//        System.out.println(sum);

//        Stream<Course> courseStream = courseService.getCourses().stream();
//
//        //COLLECT
//        List<CourseDTO> collect = courseStream.map(CourseDTO::fromCourse).collect(Collectors.toList());
//
//        //flatMap-ile mamy wszystkich studentow
//        int sum = courseStream.map(course -> course.getStudents().size()).mapToInt(Integer::intValue).sum();//???? czy to dziala?
//        System.out.println(sum);
//
//        //FLAT_MAP
//        //Stream<Course> -> Stream<List<Student>>
//        //Stream<Course> -> Stream<Student>
//        //flatMap [[1,2],[4,5]] -> [1,2,4,5]
//        long count = courseStream.flatMap(course -> course.getStudents().stream()).distinct().count();
//        System.out.println(count);
//
//        List<Student> studentList = courseStream.flatMap(course -> course.getStudents().stream()).distinct().collect(Collectors.toList());
//
//        //suma wieku wszystkich studentow REDUCE
//        int i = courseStream.flatMap(course -> course.getStudents().stream()).distinct().map(student -> student.age).mapToInt(Integer::intValue).sum();
//        System.out.println(i);
//
//        int i = courseStream.flatMap(course -> course.getStudents().stream()).distinct().reduce(0, (i1, i2) -> i1 + i2.age, (a ,b) -> a+b);
//        System.out.println(i);
//
//        //groupBy
//        Map<Integer, List<Student>> collect = courseStream.flatMap(course -> course.getStudents().stream()).collect(Collectors.groupingBy(student -> student.age));
//        collect.get(21).forEach(System.out::println);
//
//        Map<String, Double> collect = courseStream.collect(Collectors.groupingBy(course -> course.name, Collectors.averagingDouble(c -> c.students.size())));
//        collect.forEach((s, aDouble) -> System.out.println(aDouble));

    }

}

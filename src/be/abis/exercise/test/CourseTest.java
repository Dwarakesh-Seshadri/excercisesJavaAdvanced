package be.abis.exercise.test;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.MemoryCourseRepository;

import java.util.Comparator;
import java.util.List;

public class CourseTest {

    public static void main(String[] args) {

        CourseRepository cr = new MemoryCourseRepository();
        List<Course> courses = cr.findAllCourses();

        courses.stream()
    //            .sorted(Comparator.comparing(Course::getDays).thenComparing(Course::getDailyPrice).reversed())
                .sorted(Comparator.comparing(Course::getDays).thenComparing((Comparator.comparing(Course::getDailyPrice)).reversed()))
                .forEach(System.out::println);
    }
}

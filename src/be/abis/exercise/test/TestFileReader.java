package be.abis.exercise.test;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.FileCourseRepository;

import java.io.IOException;
import java.util.List;

public class TestFileReader {
    public static void main(String[] args) throws IOException {
        FileCourseRepository fr = new FileCourseRepository();
        List<Course> courseList = fr.findAllCourses();
        courseList.forEach(System.out::println);
    }
}

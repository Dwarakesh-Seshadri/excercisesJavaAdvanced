package be.abis.exercise.test;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.MemoryCourseRepository;

import java.sql.SQLOutput;
import java.util.List;

public class TestStringBuilder {
    public static void main(String[] args) {
        CourseRepository cr = new MemoryCourseRepository();
        List <Course> courseList = cr.findAllCourses();

        System.out.println("The content of the course are :" + CourseRepository.formatCourse((courseList.getFirst())));
    }
}

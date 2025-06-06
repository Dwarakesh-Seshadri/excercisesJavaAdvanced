package be.abis.exercise.test;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.FileCourseRepository;
import be.abis.exercise.repository.MemoryCourseRepository;

import java.io.IOException;
import java.util.List;

public class TestParseCourse {
    public static void main(String[] args) throws IOException {
        CourseRepository cr = new FileCourseRepository();
        String s = "DB2, an overview;5;550.0;30/4/1986";
        System.out.println((((FileCourseRepository)cr).parseCourse(s)).toString());;
    }
}

package be.abis.exercise.test;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.FileCourseRepository;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TestFileWriter {
    public static void main(String[] args) throws IOException {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("d/M/yyyy");
        Course c1 = new Course("Fotran Programming",5,100.0, LocalDate.parse("27/5/1997",dft));
        CourseRepository fr = new FileCourseRepository();
        fr.addCourse(c1);

        fr.printAllCourses();

    }
}

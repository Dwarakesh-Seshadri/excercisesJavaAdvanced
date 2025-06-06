package be.abis.exercise.repository;

import be.abis.exercise.model.Course;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface CourseRepository {

    List<Course> findAllCourses();
    void addCourse(Course c) throws IOException;
    void printAllCourses();

    static String formatCourse(Course c){
        StringBuilder courseRecord = new StringBuilder();
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("d/M/yyyy");
        courseRecord.append(c.getTitle())
                .append(";")
                .append(c.getDays())
                .append(";")
                .append(c.getDailyPrice())
                .append(";")
                .append(c.getReleaseDate().format(dft));
        return String.valueOf(courseRecord);
    }
}

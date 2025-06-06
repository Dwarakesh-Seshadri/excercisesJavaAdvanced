package be.abis.exercise.repository;

import be.abis.exercise.model.Course;

import javax.swing.text.DateFormatter;
import javax.swing.tree.DefaultTreeCellEditor;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MemoryCourseRepository implements CourseRepository{

    private List<Course> courses = new ArrayList<>();


    public MemoryCourseRepository(){
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("d/M/yyyy");
        courses.add(new Course("DB2, an overview",5,550.0, LocalDate.parse("30/4/1986",dft)));
        courses.add(new Course("Workshop SQL",2,475.0, LocalDate.parse("9/1/1990",dft)));
        courses.add(new Course("Java Programming",5,500.0, LocalDate.parse("27/5/1997",dft)));
        courses.add(new Course("Maven",1,450.0, LocalDate.parse("11/6/2007",dft)));
        courses.add(new Course("Programming with Spring",3,525.0, LocalDate.parse("21/3/2008",dft)));
    }

    @Override
    public List<Course> findAllCourses() {
        return courses;
    }

    @Override
    public void addCourse(Course c) {
        courses.add(c);
    }

    public void printAllCourses(){
        DecimalFormat df = new DecimalFormat("#.0");
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("nl","BE"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd,yyyy");
        System.out.println("-".repeat(100));
        System.out.printf("%-42s%15s%43s\n"," ","Course Overview"," ");
        System.out.println("-".repeat(100));
        System.out.printf("%-12s%30s%20s%26s%12s\n","Course Title"," ","Total Price with VAT"," ","Release Date");
        System.out.println("-".repeat(100));
        courses.stream()
                .sorted(Comparator.comparing(Course::getDays).thenComparing(course -> course.calculateVAT()))
                .forEach(course-> System.out.printf("%-42s%-45s%-12s\n",
                                                    course.getTitle(),
                                                    nf.format(course.calculateVAT()),
                                                    course.getReleaseDate().format(dtf)));


    }


}

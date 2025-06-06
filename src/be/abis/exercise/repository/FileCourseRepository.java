package be.abis.exercise.repository;

import be.abis.exercise.model.Course;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class FileCourseRepository implements CourseRepository{

    private List<Course> courses = new ArrayList<>();
    @Override
    public List<Course> findAllCourses() {
        return courses;
    }

    @Override
    public void addCourse(Course c) throws IOException {
        Path path = Paths.get("\\temp\\javacourses\\courses.csv");
        try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8")
                , StandardOpenOption.APPEND)) {
            writer.newLine();
            writer.write(CourseRepository.formatCourse(c));
            courses.add(c);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void printAllCourses() {
        DecimalFormat df = new DecimalFormat("#.0");
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("nl","BE"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd,yyyy");
        try {
            PrintWriter printFile = new PrintWriter("\\temp\\javacourses\\newcourses.csv");
            printFile.println("-".repeat(100));
            printFile.printf("%-42s%15s%43s\n"," ","Course Overview"," ");
            printFile.println("-".repeat(100));
            printFile.printf("%-12s%30s%20s%26s%12s\n","Course Title"," ","Total Price with VAT"," ","Release Date");
            printFile.println("-".repeat(100));
            courses.stream()
                    .sorted(Comparator.comparing(Course::getDays).thenComparing(course -> course.calculateVAT()))
                    .forEach(course-> printFile.printf("%-42s%-45s%-12s\n",
                            course.getTitle(),
                            nf.format(course.calculateVAT()),
                            course.getReleaseDate().format(dtf)));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public FileCourseRepository() throws IOException {
        readFile();
    }

    public Course parseCourse(String s){
        String[] courseWithFormat = s.split(";");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        Course c = new Course();
        c.setTitle(courseWithFormat[0]);
        c.setDays(Integer.parseInt(courseWithFormat[1]));
        c.setDailyPrice(Double.parseDouble(courseWithFormat[2]));
        c.setReleaseDate(LocalDate.parse(courseWithFormat[3],dtf));
        return c;
    }

    public void readFile() throws IOException {
        Path path = Paths.get("\\temp\\javacourses\\courses.csv");
        try {
            BufferedReader reader = Files.newBufferedReader(path, Charset.forName("US-ASCII"));
            String line = null;
            while ((line=reader.readLine())!=null){
                  courses.add(parseCourse(line));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }


    }

}

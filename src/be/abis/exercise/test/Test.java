package be.abis.exercise.test;

import be.abis.exercise.exception.PersonNotFoundException;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.MemoryCourseRepository;
import be.abis.exercise.repository.MemoryPersonRepository;
import be.abis.exercise.repository.PersonRepository;

import java.util.List;

public class Test  {

    public static void main(String[] args) {
        PersonRepository pr = new MemoryPersonRepository();
        List<Person> persons = pr.findAllPersons();



        System.out.println("All persons:");
        for (Person p: persons){
            System.out.println(p);
            boolean result = doTheTest(s -> s.startsWith("S"),p.getFirstName());
            System.out.println("First Name with S: " + (result? "Yes":"No"));
        }

        CourseRepository cr = new MemoryCourseRepository();
        List<Course> courses = cr.findAllCourses();

        System.out.println("\nAll courses:");
        for (Course c: courses){
            System.out.println(c);
        }



    }

    static boolean doTheTest(TestSomethingInterface tsi, String s){
            return tsi.testSomething(s);
    }


}

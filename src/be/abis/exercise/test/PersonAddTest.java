package be.abis.exercise.test;

import be.abis.exercise.exception.PersonAlreadyExistException;
import be.abis.exercise.model.Person;
import be.abis.exercise.repository.MemoryPersonRepository;
import be.abis.exercise.repository.PersonRepository;

import java.time.LocalDate;
import java.util.List;

public class PersonAddTest {
    public static void main(String[] args) {
        PersonRepository pr = new MemoryPersonRepository();
        List<Person> personList = pr.findAllPersons();

        Person person1 = new Person("Dwara", "Sesha", LocalDate.of(1978, 4, 10),"sschillebeeckx@abis.be","somepass1","nl");
        Person person2 = new Person("Dwara", "Sesha", LocalDate.of(1978, 4, 10),"sschillebeeckx@abis.be","somepass1","nl");
        try {
            pr.addPerson(person1);
            personList.forEach(System.out::println);
            System.out.println("************next case*************");
            pr.addPerson(person2);
            personList.forEach(System.out::println);
        } catch (PersonAlreadyExistException e) {
            System.out.println(e.getMessage());;
        }


    }
}

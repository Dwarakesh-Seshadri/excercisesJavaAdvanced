package be.abis.exercise.test;

import be.abis.exercise.model.Person;
import be.abis.exercise.repository.MemoryPersonRepository;
import be.abis.exercise.repository.PersonRepository;

import java.util.Comparator;
import java.util.List;

public class PersonStreamTest {

    public static void main(String[] args) {
        PersonRepository pr = new MemoryPersonRepository();
        List<Person> personList = pr.findAllPersons();

        System.out.println("******** excr a**********************");
        personList.stream()
                .filter(person -> person.getLastName().startsWith("S"))
                .forEach(System.out::println);

        System.out.println("******** excr b**********************");
        personList.stream()
                .filter(person -> person.calculateAge()>40)
                .forEach(System.out::println);

        System.out.println("******** excr c**********************");
        personList.stream()
                .filter(person -> person.getLastName().startsWith("S"))
                .filter(person -> person.calculateAge()>40)
                .forEach(System.out::println);

        System.out.println("******** excr d**********************");
        personList.stream()
                .sorted((person1,person2) -> person2.getLastName().compareTo(person1.getLastName()))
                .forEach(System.out::println);

        System.out.println("******** excr e**********************");
        personList.stream()
                .filter(person -> (person.getCompany())!=null)
                .filter(person -> (person.getCompany().getAddress().getTown().equalsIgnoreCase("Leuven")))
                .sorted((person1,person2) -> person1.calculateAge()-person2.calculateAge())
                .forEach(System.out::println);


        System.out.println("******** excr f**********************");
        personList.stream()
                .filter(person -> (person.getCompany())!=null)
                .map(person -> person.getCompany().getName())
                .distinct()
                .forEach(System.out::println);

    }
}

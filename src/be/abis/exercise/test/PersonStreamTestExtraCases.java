package be.abis.exercise.test;

import be.abis.exercise.model.Person;
import be.abis.exercise.repository.MemoryPersonRepository;
import be.abis.exercise.repository.PersonRepository;

import java.util.List;

public class PersonStreamTestExtraCases {

    public static void main(String[] args) {
        PersonRepository pr = new MemoryPersonRepository();
        List<Person> personList = pr.findAllPersons();

        System.out.println("******** excr c**********************");
        System.out.println(personList.stream()
                .filter(person -> (person.getCompany())!=null)
                .filter(person -> person.getCompany().getAddress().getTown().equalsIgnoreCase("Leuven"))
                .count());



        System.out.println("******** excr d**********************");
        System.out.println("The youngest person in the List is \n" +
                (personList.stream()
                .min((person1,person2) -> person1.calculateAge() - person2.calculateAge())));
    }
}

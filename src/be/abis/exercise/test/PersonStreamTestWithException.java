package be.abis.exercise.test;

import be.abis.exercise.exception.PersonNotFoundException;
import be.abis.exercise.model.Person;
import be.abis.exercise.repository.MemoryPersonRepository;
import be.abis.exercise.repository.PersonRepository;

import java.util.List;

public class PersonStreamTestWithException {
    public static void main(String[] args) {
        PersonRepository pr = new MemoryPersonRepository();
        List<Person> personList = pr.findAllPersons();

        System.out.println("************excr 7.2 with exception*****************");
        try {
            Person person1 = pr.findPersonByEmailAndPassword("111@abis.be","somepddd1");
            System.out.println(person1);
        } catch (PersonNotFoundException e) {
            System.out.println(e.getMessage());
        }
/*
        System.out.println("************excr 7.1 wihtout exception*****************");
        try {
            Person person1 = pr.findPersonById(1);
            System.out.println(person1);
        } catch (PersonNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("************excr 7.1 with exception*****************");
        try {
            Person person1 = pr.findPersonById(25);
            System.out.println(person1);
        } catch (PersonNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("************excr 7.2 wihtout exception*****************");
        try {
            Person person1 = pr.findPersonByEmailAndPassword("sschillebeeckx@abis.be","somepass1");
            System.out.println(person1);
        } catch (PersonNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("************excr 7.2 with exception*****************");
        try {
            Person person1 = pr.findPersonByEmailAndPassword("111@abis.be","somepddd1");
            System.out.println(person1);
        } catch (PersonNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("************excr 7.3 wihtout exception*****************");
        try {
            List<Person> persons = pr.findPersonsForCompany("ABIS");
            System.out.println(persons);
        } catch (PersonNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("************excr 7.3 with exception*****************");
        try {
            List<Person> persons = pr.findPersonsForCompany("notng");
        } catch (PersonNotFoundException e) {
            System.out.println(e.getMessage());
        }
*/
    }
}

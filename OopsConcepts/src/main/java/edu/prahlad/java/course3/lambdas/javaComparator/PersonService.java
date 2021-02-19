package edu.prahlad.java.course3.lambdas.javaComparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonService {
    public static List<Person> getPersons(List<Person> persons) {
        //Created an anonymous Comparator, which sorts the Person object
        // on the basis of name
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        return persons;
    }

    public static List<Person> getPersonsLambda(List<Person> persons) {
        //Created an anonymous Comparator, which sorts the Person object
        // on the basis of name
        Collections.sort(persons, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        return persons;
    }

    public static List<Person> getPersonsLambda2(List<Person> persons) {
        //Created an anonymous Comparator, which sorts the Person object
        // on the basis of name
        Collections.sort(persons, Comparator.comparing(Person::getName));
        return persons;
    }
}

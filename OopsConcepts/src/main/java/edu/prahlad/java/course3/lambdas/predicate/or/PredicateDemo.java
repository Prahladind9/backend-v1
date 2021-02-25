package edu.prahlad.java.course3.lambdas.predicate.or;

import java.util.function.Predicate;

public class PredicateDemo {

    static boolean isPersonEligibleForRetirement(Person person, Predicate<Person> predicate){
        return predicate.test(person);
    }

    public static void main(String[] args) {
        Person person = new Person("Alex", 23, 3);

        //Created a predicate. It returns true if age is greater than 18.
        Predicate<Person> greaterThanEighteen = p -> p.age > 18;
        //Created a predicate. It returns true if year of service is greater than 30.
        Predicate<Person> serviceMoreThanThirty = p -> p.yearsOfService > 30;

        Predicate<Person> predicate = greaterThanEighteen.or(serviceMoreThanThirty);

        boolean eligible = isPersonEligibleForRetirement(person, predicate);
        System.out.println("Person is eligible for retirement: "+ eligible);
    }
}

class Person{
    String name;
    int age;
    int yearsOfService;

    public Person(String name, int age, int yearsOfService) {
        this.name = name;
        this.age = age;
        this.yearsOfService = yearsOfService;
    }
}
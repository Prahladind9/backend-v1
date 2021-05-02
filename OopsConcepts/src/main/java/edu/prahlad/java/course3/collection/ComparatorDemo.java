package edu.prahlad.java.course3.collection;

import edu.prahlad.java.course3.lambdas.javaComparator.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

    public static void main(String args[]){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Jane",54, "USA"));
        personList.add(new Person("Dave",21, "USA"));
        personList.add(new Person("Carl",34, "USA"));

        // Here we are using an anonymous comparator to sort the List.
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        personList.forEach(System.out::println);

        // Sorting the List using comparing() method of Comparator.
        Collections.sort(personList, Comparator.comparing(Person::getName));
        personList.forEach(System.out::println);

        //Using thenComparing() method to sort the List on the basis of two criterias.
        Collections.sort(personList, Comparator.comparing(Person::getName).thenComparing(Person::getAge));
        personList.forEach(System.out::println);


        List<String> fruits = new ArrayList<>();
        fruits.add("guava");
        fruits.add("peach");
        fruits.add("apple");
        fruits.add("banana");

        Collections.sort(fruits, Comparator.naturalOrder());
        System.out.println(fruits);

        // Sorting the List in reverse order.
        Collections.sort(fruits, Comparator.reverseOrder());
        fruits.forEach(System.out::println);

        fruits.add(null);
        // Sorting the List keeping nulls first.
        Collections.sort(fruits, Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println(fruits);

        // Sorting the List keeping nulls last.
        Collections.sort(fruits, Comparator.nullsLast(Comparator.naturalOrder()));
        fruits.forEach(System.out::println);

    }
}

package edu.prahlad.java.oops2.association;

class Country {

    private String name;
    private int population;

    public Country(String n, int p) {
        name = n;
        population = p;
    }
    public String getName() {
        return name;
    }

}

class Person {

    private String name;
    private Country country; // An instance of Country class

    public Person(String n, Country c) {
        name = n;
        country = c;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Country: " + country.getName());
    }

}

/**
 * Aggregation follows the has-A model.
 * This creates a parent-child relationship between two classes,
 * with one class owning the object of another.
 *
 * In aggregation, the lifetime of the owned object does not depend
 * on the lifetime of the owner.
 */
class AggregationRunner {

    public static void main(String args[]) {
        Country country = new Country("Utopia", 1);

        //Block of code, with scope of objects limited to the same.
        {
            Person user = new Person("Darth Vader", country);
            user.printDetails();
        }
        // The user object's lifetime is over

        System.out.println(country.getName()); // The country object still exists!
    }

}
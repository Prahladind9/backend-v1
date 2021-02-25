package edu.prahlad.java.course3.lambdas.predicate.isEqual;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = Predicate.isEqual("Hellp");

        //The same thing can be achieved by the below lambda
        //Predicate <String> predicate = p -> p.equals("Hello");

        System.out.println(predicate.test("Welcome"));
    }
}

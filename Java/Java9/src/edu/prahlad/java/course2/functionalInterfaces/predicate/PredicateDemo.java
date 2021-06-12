package edu.prahlad.java.course2.functionalInterfaces.predicate;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> isLongerThan5 = str -> str.length() > 5;
        System.out.println(isLongerThan5.test("sky"));

        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.startsWith("}");

        // && || !
        Predicate<String> hasLeftAndRightBraces = hasLeftBrace.and(hasRightBrace);
        hasLeftAndRightBraces.test("{key:value}");

    }
}

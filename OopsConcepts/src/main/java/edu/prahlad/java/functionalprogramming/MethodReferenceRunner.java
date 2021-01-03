package edu.prahlad.java.functionalprogramming;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Method reference > more readable code
 */
public class MethodReferenceRunner {

    public static void print(Integer number){
        System.out.println(number);
    }

    public static void main(String[] args) {
        List.of("Ant", "Bat").stream()
                .map(s -> s.length())
                .forEach(s -> System.out.println(s));

        System.out.println("**************");
        List.of("Ant", "Bat").stream()
                .map(s -> s.length())
                .forEach(System.out::println);

        System.out.println("**************");
        List.of("Ant", "Bat").stream()
                .map(String::length)
                .forEach(MethodReferenceRunner::print);

        System.out.println("**************");
        Integer max = List.of(22,33,12,3).stream()
                .filter(e -> e%2 ==0)
                .max((n1, n2) -> Integer.compare(n1,n2))
                .orElse(0);
        System.out.println(max);

        System.out.println("**************");
        Integer maxV = List.of(22,33,12,3).stream()
                .filter(MethodReferenceRunner::isEven)
                .max(Integer::compare)
                .orElse(0);
        System.out.println(maxV);

    }


    public static boolean isEven(Integer number){
        return number%2 ==0;
    }
}

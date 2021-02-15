package edu.prahlad.java.course1.functionalprogramming;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * First class status to methods
 * 1. Storing functions in variables
 * 2. Passing functions to methods
 * 3. Returning functions from methods
 *
 * telling what to do .. not how to do
 *
 * lambda expression
 * Intermediate operations
 * terminal operations
 *
 * functional interfaces
 */
public class FPNumberRunner {
    public static void main(String[] args) {

        /*
         * 1. Storing functions in variables
         * 2. Passing functions to methods
         * 3. Returning functions from methods
         *
         */

        Predicate<Integer> evenPredicate = createEvenPredicate(0);
        Predicate<Integer> oddPredicate = e -> e % 2 == 0;

        List.of(22,33,12,3).stream()
                .filter(evenPredicate)
                .map(n -> n*n)
                .forEach(System.out::println);


        List<Integer> numbers = List.of(4,6,8,3,134,45);
        System.out.println(fpSum(numbers));

        IntStream.range(1,10).map(e -> e * e).forEach(System.out::println);
        List.of("Apple", "ANt", "Car").stream().map(e -> e.toLowerCase(Locale.ROOT)).forEach(System.out::println);
        List.of("Apple", "ANt", "Car").stream().map(e -> e.length()).forEach(System.out::println);

        System.out.println(IntStream.range(1,11).reduce(0, (n1, n2)-> n1+n2));

        //Comparator
        Optional<Integer> val = List.of(22,33,12,3).stream().max((n1, n2) -> Integer.compare(n1,n2));
        System.out.println(val.get());

        System.out.println(List.of(22,33,12,3).stream().min((n1, n2) -> Integer.compare(n1,n2)));
        System.out.println(List.of(22,33,12,3).stream().min((n1, n2) -> Integer.compare(n1,n2)).get());

        //Filter and get list of odd numbers
        System.out.println(List.of(22,33,12,3).stream().filter(e -> e%2 ==1).collect(Collectors.toList()));
        System.out.println(IntStream.range(1,11).map(e-> e*e).boxed().collect(Collectors.toList()));
    }

    private static Predicate<Integer> createEvenPredicate(int i) {
        return e -> e % 2 == i;
    }

    private static Integer fpSum(List<Integer> numbers) {
        //        numbers.stream().forEach(System.out::println);
        return numbers.stream()
                .reduce(0,
                        (number1, number2) ->
                         number1 + number2);
    }

    private static Integer fpSumDebug(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0,
                        (number1, number2) ->
                        {
                            System.out.println(number1 + " " + number2);
                            return number1 + number2;
                        });
    }
}

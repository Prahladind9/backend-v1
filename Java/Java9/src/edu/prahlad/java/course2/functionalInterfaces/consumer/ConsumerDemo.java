package edu.prahlad.java.course2.functionalInterfaces.consumer;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        consumerBasics();
        chainingConsumers();
    }

    private static void chainingConsumers() {
        List<String> list = List.of("a", "b", "c");
        Consumer<String> print = (String item) -> {
            System.out.println(item);
        };

        Consumer<String> printSimplified = item -> System.out.println(item);
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());

        list.forEach(print.andThen(printSimplified.andThen(printUpperCase)));
    }

    private static void consumerBasics() {
        List<Integer> list = List.of(1,2,3);
        //Imperative Programming (for, if/else, switch/case)
        for(var item: list)
            System.out.println(item);

        //Declarative Programming
        list.forEach((Integer item) -> {
            System.out.println(item);
        });
        list.forEach(item -> System.out.println(item));
        list.forEach(System.out::println);
    }
}

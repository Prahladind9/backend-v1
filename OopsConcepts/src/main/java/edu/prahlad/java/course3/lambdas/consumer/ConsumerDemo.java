package edu.prahlad.java.course3.lambdas.consumer;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> stringConsumer = s -> System.out.println(s);
        stringConsumer.accept("Hello World.");

        Consumer<Integer> integerConsumer = i -> System.out.println("Integer value = "+ i);
        integerConsumer.accept(5);

        Consumer<String> consumer1 = (arg) -> System.out.println(arg + "My name is Rao.");
        Consumer<String> consumer2 = (arg) -> System.out.println(arg + "Iam from India.");

        consumer1.andThen(consumer2).accept("Hello. ");
    }
}

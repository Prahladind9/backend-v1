package edu.prahlad.java.course2.functionalInterfaces.function;

import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {
    public static void main(String[] args) {
        UnaryOperator<Integer> square = n -> n * n;
        UnaryOperator<Integer> increment = n -> n + 1;

        var result = increment.andThen(square).apply(1);
        System.out.println(result);
    }
}

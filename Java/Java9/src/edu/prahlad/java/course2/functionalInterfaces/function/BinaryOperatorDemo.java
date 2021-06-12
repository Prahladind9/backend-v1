package edu.prahlad.java.course2.functionalInterfaces.function;

import java.util.function.BinaryOperator;
import java.util.function.Function;

//BinaryOperator<T> = BiFunction<T,T,T>
public class BinaryOperatorDemo {
    public static void main(String[] args) {
        //a, b -> a+b -> square
        BinaryOperator<Integer> add = (a, b) -> a + b;
        Function<Integer, Integer> square = a -> a * a;

        var result = add.andThen(square).apply(1, 2);
        System.out.println(result);
    }
}

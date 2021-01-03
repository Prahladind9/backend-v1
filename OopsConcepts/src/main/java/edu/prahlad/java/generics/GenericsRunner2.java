package edu.prahlad.java.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsRunner2 {

    //wildcard - upper bounded wildcard
    static double sumOfNumberList(List<? extends Number> numbers){
        double sum = 0.0;
        for(Number number: numbers){
            sum += number.doubleValue();
        }

        return sum;
    }

    //wildcard - lower bounded wildcard
    static void addACoupleOfValues(List<? super Number> numbers){
        numbers.add(1);
        numbers.add(1.0);
        numbers.add(1.0f);
        numbers.add(1l);
    }

    public static void main(String[] args) {

        List emptyList = new ArrayList<Number>();
        System.out.println(emptyList);
        addACoupleOfValues(emptyList);
        System.out.println(emptyList);

        System.out.println(sumOfNumberList(List.of(1,3,6,234,6.78)));
        System.out.println(sumOfNumberList(List.of(1,3,7l,6.78)));
    }


}

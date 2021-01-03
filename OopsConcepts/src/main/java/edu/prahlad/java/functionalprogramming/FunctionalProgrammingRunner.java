package edu.prahlad.java.functionalprogramming;

import java.util.List;

public class FunctionalProgrammingRunner {
    public static void main(String[] args) {
        List<String> list = List.of("Apple", "Car", "Ribbon", "Bat", "Cat");
        printBasicWithFiltering(list);
        System.out.println("*************");
        printWithFPWithFiltering(list);

    }


    //Function as parameter and loop using lambda expression
    private static void printWithFP(List<String> list) {
        list.stream().forEach(element -> System.out.println(element));
    }

    //Function as parameter and loop using lambda expression & filter
    private static void printWithFPWithFiltering(List<String> list) {
        list.stream()
                .filter(element -> element.endsWith("at"))
                .forEach(element -> System.out.println(element));
    }

    private static void printBasic(List<String> list) {
        for(String string: list){
            System.out.println(string);
        }
    }


    private static void printBasicWithFiltering(List<String> list) {
        for(String string: list){
            if(string.endsWith("at"))
                System.out.println(string);
        }
    }
}

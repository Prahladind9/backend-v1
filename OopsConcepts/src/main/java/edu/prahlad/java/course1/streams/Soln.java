package edu.prahlad.java.course1.streams;

import java.util.*;
import java.util.stream.Collectors;

public class Soln {

    public static void main(String[] args) {
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));

        List<String> phones = people.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        phones.stream().forEach(System.out::println);

        Random rand = new Random();
        rand.ints().limit(5).sorted().forEach(System.out::println);


    }


}

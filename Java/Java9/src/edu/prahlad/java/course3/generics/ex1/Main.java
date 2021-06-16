package edu.prahlad.java.course3.generics.ex1;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Comparable<Date> c = new Date();
        //System.out.println(c.compareTo("Monday")); - Strong Compile Time check

        Pair<Integer, String> p1 = new OrderedPair<>(1, "apple");
        Pair<String, Integer> p2 = new OrderedPair<>("mango", 2);
        print(p1.getKey(), p1.getValue());
        print(p2.getKey(), p2.getValue());
        print("Happy", "Day");
    }

    public static <K, V> void print(K key, V value) {
        System.out.println("Key: " + key);
        System.out.println("Value: " + value);
    }

}

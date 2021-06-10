package edu.prahlad.java.course2.collections;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("sky");
        set.add("is");
        set.add("blue");
        set.add("blue");
        System.out.println(set);

        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "a", "b", "c", "c");
        Set<String> hashset = new HashSet<>(collection);
        System.out.println(hashset);

        Set<String> set1 = new HashSet<>(
                Arrays.asList("a", "b", "c")
        );
        Set<String> set2 = new HashSet<>(
                Arrays.asList("b", "c", "d")
        );

        //Union
        set1.addAll(set2);
        System.out.println(set1);

        //Intersection
        set2.retainAll(set1);
        System.out.println(set2);

        //Difference
        set1.removeAll(set2);
        System.out.println(set1);
    }
}

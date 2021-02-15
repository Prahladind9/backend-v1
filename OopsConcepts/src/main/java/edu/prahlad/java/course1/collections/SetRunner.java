package edu.prahlad.java.course1.collections;

import java.util.*;

public class SetRunner {

    public static void main(String[] args) {
        List<Character> characters = List.of('A', 'Z', 'A', 'B', 'Z', 'F');

        Set<Character> treeSet = new TreeSet<>(characters);
        System.out.println("treeSet " + treeSet);

        Set<Character> linkedHasSet = new LinkedHashSet<>(characters);
        System.out.println("linkedHasSet "+ linkedHasSet);

        Set<Character> hasSet = new HashSet<>(characters);
        System.out.println("hasSet "+ hasSet);
    }
}

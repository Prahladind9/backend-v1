package edu.prahlad.java.course1.tips;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class LengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}

public class AnonymousClassRunner {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>(List.of("Ant", "Cat", "Lion"));
        Collections.sort(animals, new LengthComparator());
        System.out.println(animals);

        //AnonymousClass Example below
        Collections.sort(animals, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        System.out.println(animals);
    }
}

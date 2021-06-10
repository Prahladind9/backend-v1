package edu.prahlad.java.course2.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void showList(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(0, "!");
        Collections.addAll(list, "d", "e", "f", "d");
        System.out.println(list);
        list.set(0, "a+");
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.get(0));
        System.out.println(list.indexOf("a+"));
        System.out.println(list.indexOf("d"));
        System.out.println(list.lastIndexOf("d"));

        System.out.println(list.subList(0, 2));

    }

    public static void showCollection(){
        Collection<String> collection = new ArrayList<>();
        collection.add("a");
        collection.add("b");
        collection.add("c");
        Collections.addAll(collection, "d","e", "f");

        Collection<String> other = new ArrayList<>();
        other.addAll(collection);

        System.out.println("== "+ (collection == other));
        System.out.println("equals "+ (collection.equals(other)));

        System.out.println(collection);
        collection.remove("a");
        System.out.println(collection.size());
        System.out.println(collection.contains("c"));

        var objectArray = collection.toArray();
        var stringArray = collection.toArray(new String[0]);

        collection.clear();
        System.out.println(collection.isEmpty());

    }
}

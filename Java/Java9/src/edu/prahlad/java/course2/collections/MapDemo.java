package edu.prahlad.java.course2.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        var c1 = new Customer("a", "e1");
        var c2 = new Customer("b", "e2");
        Map<String, Customer> map = new HashMap<>();
        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);

        var unknown = new Customer("Unknown", "");

        System.out.println(map.get("e1"));
        System.out.println(map.containsKey("e1o"));
        System.out.println(map.get("e1o"));
        System.out.println(map.getOrDefault("e1o", unknown));

        map.replace("e1", new Customer("a++", "e1"));
        System.out.println(map);

        for(var entry: map.entrySet()) {
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        for (var customer: map.values())
            System.out.println(customer);

        for (var key: map.keySet())
            System.out.println(key);
    }
}

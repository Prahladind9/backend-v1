package edu.prahlad.java.course3.collection;

import java.util.HashMap;
import java.util.Map;

public class MapUpgrades {
    public static void main(String args[]){
        Map<String , Integer> fruits = new HashMap<>();

        // We need to add 20 bananas in map.
        // Below line will throw NullPointerException if banana
        //is already not present in the map.

        //fruits.put("banana", fruits.get("banana") + 20);

        //This is the correct way to update map value fefore Java 8
        if (fruits.containsKey("banana")) {
            fruits.put("banana", fruits.get("banana") + 20);
        } else {
            fruits.put("banana", 20);
        }


        fruits.put("banana", fruits.getOrDefault("banana", 0) + 20);
        System.out.println(fruits);

        fruits.put("apple", 20);
        System.out.println(fruits.get("apple"));

        fruits.putIfAbsent("apple", 30);
        System.out.println(fruits.get("apple"));


        int val = fruits.compute("apple", (k, v) -> v + 10);
        System.out.println(val);

        val = fruits.computeIfAbsent("banana", v ->  10);
        System.out.println(val);

        fruits.replace("apple", 50);
        System.out.println(fruits.get("apple"));

        fruits.replace("apple", 50, 70);
        System.out.println(fruits.get("apple"));

        fruits.replaceAll((k, v) -> 50);  //Value becomes 50 for all keys

        System.out.println(fruits.get("apple"));
        System.out.println(fruits.get("banana"));

        fruits.remove("apple" , 30);  //apple will not be removed because the value is 20
        System.out.println(fruits.get("apple"));

        fruits.remove("apple" , 50);  //apple will be removed
        System.out.println(fruits.get("apple"));

        fruits.remove("apple");  //apple will be removed
        System.out.println(fruits.get("apple"));


        fruits.put("apple", 10);
        fruits.put("banana", 20);
        fruits.put("orange", 30);

        fruits.forEach((k,v) -> System.out.println("Key: " + k + " Value: " + v));
    }
}

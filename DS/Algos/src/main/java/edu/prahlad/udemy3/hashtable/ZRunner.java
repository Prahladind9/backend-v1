package edu.prahlad.udemy3.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ZRunner {
    public static void main(String[] args) {
//        practice();

        CharFinder charFinder = new CharFinder();
        System.out.println("findFirstNonRepeatedCharacter: " +
                charFinder.findFirstNonRepeatedCharacter("a rainy evening"));
        System.out.println("findFirstRepeatedChar: " +
                charFinder.findFirstRepeatedChar("green apple"));

        HashTable hashTable = new HashTable();
        hashTable.put(6, "A"); //1
        hashTable.put(8, "B"); //3
        hashTable.put(11, "C"); //Collision
        hashTable.put(6, "A+"); //1
        System.out.println(hashTable);
        System.out.println(hashTable.get(6));
        hashTable.remove(6);
        //hashTable.remove(6);
    }

    private static void practice() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Rao");
        map.put(2, "Mosh");
        map.put(3, "Mary");
        map.put(3, "Marianne");
        map.put(4, null);
        map.put(null, null);
        System.out.println(map);
        map.remove(null);
        System.out.println(map.get(3));
        System.out.println(map.containsKey(3));//O(1)
        System.out.println(map.containsValue("Rao"));//O(n)

        for (var item : map.entrySet()) {
            System.out.println(item);
        }

        //Set accepts - only unique value
        Set<Integer> set = new HashSet<>();
        int[] numbers = {1, 2, 3, 4, 12, 3, 4, 5};
        for (var number : numbers) {
            set.add(number);
        }
        System.out.println(set);


        System.out.println("Orange".hashCode());
    }
}

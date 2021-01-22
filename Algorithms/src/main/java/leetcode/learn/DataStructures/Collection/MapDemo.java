package leetcode.learn.DataStructures.Collection;

import java.awt.*;
import java.util.*;

public class MapDemo {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        TreeMap<String, String> treeMap  = new TreeMap<>();
        treeMap.size();


        Map<String, Color> favoriteColors = new HashMap<>();
        favoriteColors.put("Juliet", Color.BLUE);
        favoriteColors.put("Romeo", Color.GREEN);
        favoriteColors.put("Adam", Color.RED);
        favoriteColors.put("Eve", Color.BLUE);

        //Print all keys and values in the map
        Set<String> keySet = favoriteColors.keySet();
        for(String key: keySet){
            Color value = favoriteColors.get(key);
            System.out.println(key + " : " + value);
        }

        System.out.println(favoriteColors);
        System.out.println(favoriteColors.keySet());
        System.out.println(favoriteColors.values());

        Map<String, Integer> freq = new HashMap<>();
        freq.put("Juliet", 1);
        freq.put("Ugh", 1);
        freq.put("VII", 1);

        for (String name: favoriteColors.keySet()) {
            freq.merge(name, 1, (oldValue, value) -> oldValue + value);
            System.out.println(freq.hashCode());
        }
        System.out.println();
        for (String name: freq.keySet()) {
            freq.merge(name, 1, (oldValue, value) -> oldValue + value);
            System.out.println(freq.hashCode());
        }

        System.out.println(freq);
        System.out.println(freq.keySet());
        System.out.println(freq.values());

        //Equals and HashCode

        /*
            final int HASH_MULTIPLIER = 31;
            int h = 0;
            for (int i = 0; i < s.length(); i++)
            {
                h = HASH_MULTIPLIER * h + s.charAt(i);
            }
            For example, the hash code of "eat" is
            31 * (31 * 'e' + 'a') + 't' = 100184
        */
    }
}

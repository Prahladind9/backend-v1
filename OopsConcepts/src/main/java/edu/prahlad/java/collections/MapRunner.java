package edu.prahlad.java.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.techiedelight.com/increment-map-value-java-8/
 */
public class MapRunner {
    public static void main(String[] args) {
        String str = "This is an awesome occasion. " +
                "This has never happened before.";

        Map<Character, Integer> occurances = new HashMap<>();

        char[] chars = str.toCharArray();
        for(char character: chars){
            occurances.put(character,
                    occurances.getOrDefault(character,0)+1);
        }

        System.out.println(occurances);



        Map<String, Integer> stringOccurances = new HashMap<>();

        String[] words = str.split(" ");
        for(String word: words){
            stringOccurances.put(word,
                    stringOccurances.getOrDefault(word,0)+1);
        }

        System.out.println(stringOccurances);
    }
}

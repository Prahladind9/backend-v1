package edu.prahlad.udemy.algorithm;

import java.util.HashMap;
import java.util.Map;

public class FC_2 {

    /**
     * Anagrams
     * Given two strings, write a function to determine if the second string is an
     * anagram of the first.
     * An anagram is a word, phrase, or name formed by rearranging the letters if another,
     * such as cinema, formed from iceman
     */

    //Frequency Counter Solution - O(n)
    private static boolean validAnagram(final String s1, final String s2){
        //EdgeCase - All values are lowercase string > no alpha-numeric combination or spaces

        if(s1.length() != s2.length())
            return false;

        final Map<Character, Integer> m1 = new HashMap<>();
        final Map<Character, Integer> m2 = new HashMap<>();

        for (char ch: s1.toCharArray()){
            m1.put(ch, m1.getOrDefault(ch, 0)+1);
        }
        for(char ch: s2.toCharArray()){
            m2.put(ch, m2.getOrDefault(ch, 0)+1);
        }

//        System.out.println("m1 "+m1);
//        System.out.println("m2 "+m2);

        return m1.equals(m2);
    }

    public static void main(String[] args) {
        System.out.println(validAnagram("anagram", "nagaram"));
        System.out.println(validAnagram("", ""));
        System.out.println(validAnagram("aa", "ab"));
        System.out.println(validAnagram("aa", "abc"));
        System.out.println(validAnagram("cinema", "iceman"));
        System.out.println(validAnagram("ama", "ama"));
    }
}

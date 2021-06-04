package edu.prahlad.CodeWithMosh.part3.stringManipulation;

import java.util.*;

public class StringUtils {

    public static int countVowels(String str) {
        //EdgeCases
        if (str == null) return 0;

        int count = 0;
        final String vowels = "aeiou";
        for (var ch : str.toLowerCase().toCharArray())
            if (vowels.indexOf(ch) != -1) count++;

        return count;
    }

    /**
     * TimeComplexity: O(n^2)
     */
    public static String reverseV0(String str) {
        if (str == null) return "";
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) //O(n)
            reversed += str.charAt(i); //O(n)

        return reversed;
    }

    /**
     * TimeComplexity: O(n)
     */
    public static String reverse(String str) {
        if (str == null) return "";
        final var reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) //O(n)
            reversed.append(str.charAt(i));//O(1)

        return reversed.toString();
    }

    //Can use stack to fill in & pop them out ...
    public static String reverseWordsV0(String sentence) {
        if (sentence == null) return "";

        final String SPLITTER = " ";
        final String[] words = sentence.split(SPLITTER);
        final StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--)
            reversed.append(words[i] + SPLITTER);

        return reversed.toString().trim();
    }

    public static String reverseWords(String sentence) {
        if (sentence == null) return "";

        final String SPLITTER = " ";
        final String[] words = sentence.trim().split(SPLITTER);
        Collections.reverse(Arrays.asList(words));
        return String.join(SPLITTER, words);
    }

    public static boolean areRotationsV0(String str1, String str2) {
        if (str1 == null || str2 == null) return false;
        if (str1.length() != str2.length()) return false;
        if ((str1 + str2).contains(str2)) return true;
        return true;
    }

    public static boolean areRotations(String str1, String str2) {
        if (str1 == null || str2 == null) return false;
        return (str1.length() == str2.length()) &&
                ((str1 + str2).contains(str2));
    }

    public static String removeDuplicates(String str) {
        if (str == null) return "";

        final StringBuilder output = new StringBuilder();
        final Set<Character> seen = new HashSet<>();
        for (var ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                output.append(ch);
            }
        }
        return output.toString();
    }

    public static char getMaxRecurringCharV0(String str) {
        if (str == null || str.isEmpty()) throw new IllegalArgumentException();
        final Map<Character, Integer> frequencies = new HashMap<>();
        for (var ch : str.toCharArray()) {
            frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);
        }

        int max = 0;
        char result = ' ';
        for (Character ch : frequencies.keySet()) {
            if (frequencies.get(ch) > max) {
                max = frequencies.get(ch);
                result = ch;
            }
        }

        return result;
    }

    //Using Histogram - ASCII characters 256
    public static char getMaxRecurringChar(String str) {
        if (str == null || str.isEmpty()) throw new IllegalArgumentException();
        final int ASCII_SIZE = 256;
        final int[] frequencies = new int[ASCII_SIZE];
        for (var ch : str.toCharArray())
            frequencies[ch]++;

        int max = 0;
        char result = ' ';
        for (var i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > max) {
                max = frequencies[i];
                result = (char) i;
            }
        }

        return result;
    }

    public static String capitalizeEveryWordOfSentence(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) return "";

        String[] words = sentence
                .trim()
                .replaceAll(" +", " ")//replace more than one space occurrences with one space
                .split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase()
                    + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }

    //TimeComplexity: O(n log n)
    public static boolean areAnagramsV0(String first, String second) {
        if (first == null || second == null ||
                first.length() != second.length())//optimizer - add as per context
            return false;

        var array1 = first.toLowerCase().toCharArray();//O(n)
        Arrays.sort(array1);//(n log n)

        var array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    /**
     * Using Histogram > considering only 26 alphabets
     * TimeComplexity: O(n)
     */
    public static boolean areAnagrams(String first, String second) {
        if (first == null || second == null)
            return false;

        final int ENGLISH_ALPHABET = 26;
        int[] frequencies = new int[ENGLISH_ALPHABET];
        first = first.toLowerCase();
        for (int i = 0; i < first.length(); i++)//O(n)
            frequencies[first.charAt(i) - 'a']++;

        second = second.toLowerCase();
        for (int i = 0; i < second.length(); i++) {
            var index = second.charAt(i) - 'a';
            if (frequencies[index] == 0)
                return false;

            frequencies[index]--;
        }
        return true;
    }

    public static boolean isPalindromeV0(String word){
        if(word == null) return false;
        //4 string iterations in this approach
        var input = new StringBuilder(word);//1
        input.reverse();                    //2
        return input.toString()             //3
                .equals(word);              //4
    }

    public static boolean isPalindrome(String word){
        if(word == null) return false;

        //half iteration - case sensitive palindrome check
        int left = 0;
        int right = word.length() -1;

        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--))
                return false;
        }

        return true;
    }
}
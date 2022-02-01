package edu.prahlad.zinterview.twillio;

import java.util.*;

public class FunWithAnargams {
    public static List<String> funWithAnagrams(List<String> words) {
        if(words == null) return new ArrayList<>();
        Map<String, String> result = new HashMap<>();

        for (String word: words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);

            String sortedWord = String.valueOf(charArray);
            if (!result.containsKey(sortedWord)) {
                result.put(sortedWord, word);
            }

        }
        List<String> res = new ArrayList<>(result.values());
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        /**
         *     4
         *
         *     code
         *
         *     aaagmnrs
         *
         *     anagrams
         *
         *     doce
         */
    }
}

package edu.prahlad.educativeio.patternforCodingQuestions.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Q) Given a string, find the length of the longest substring, which has all distinct characters.
 * TC: O(n)
 * SC: O(k), where k <= n
 */
public class NoRepeatSubstring {
    public static int findLength(String str) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if(charIndexMap.containsKey(rightChar)){
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar)+1);
            }

            charIndexMap.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}

package edu.prahlad.educativeio.patternforCodingQuestions.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(n), n no of characters in the input string; for and while => O(n + n) ~ O(n)
 * Space Complexity: O(k), as we'll be storing a maximum of K + 1 characters in the HashMap
 */
public class LongestSubstringKDistinct {


    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0)
            throw new IllegalStateException();

        if (k > str.length()) return str.length();

        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char right = str.charAt(windowStart);
            charMap.put(right, charMap.getOrDefault(right, 0) + 1);

            while (charMap.get(right) > k) {
                char left = str.charAt(windowStart);
                charMap.put(left, charMap.get(left) - 1);
                if (charMap.get(left) == 0) {
                    charMap.remove(charMap);
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}

package edu.prahlad.educativeio.patternforCodingQuestions.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Q) Given an array of characters where each character represents a fruit tree,
 *    you are given two baskets, and your goal is to put maximum number of fruits in each basket.
 *    The only restriction is that each basket can have only one type of fruit.
 *    Write a function to return the maximum number of fruits in both baskets.
 *
 * TC: O(n)
 * SC: O(1)
 *
 */
public class MaxFruitCountOf2Types {

    public static int findLength(char[] arr) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> map = new HashMap<>(); //fruitFrequencyMap

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            map.put(arr[windowEnd], map.getOrDefault(arr[windowEnd], 0) + 1);
            while (map.size() > 2) {
                map.put(arr[windowStart], map.get(arr[windowStart]) - 1);
                if (map.get(arr[windowStart]) == 0) {
                    map.remove(arr[windowStart]);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, (windowEnd - windowStart + 1));
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}

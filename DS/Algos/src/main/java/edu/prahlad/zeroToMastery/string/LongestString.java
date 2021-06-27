package edu.prahlad.zeroToMastery.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest
 * substring without repeating characters
 *
 * Leetcode
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestString {

    /**
     * 0) Visualize the question
     *     "abccabb" - 3
     *
     * 1) Verify the constraints
     *      a) Is the substring contiguous?
     *          Yes, look for a substring not a subsequence
     *              substring vs subsequence
     *      b) Does case sensitivity matter?
     *          No, assume all characters in the string are lowercase
     *
     * 2) Write out some test cases
     *      "abccabb"   3
     *      "cccccc"    1
     *      ""          0
     *      "abcbda"    4
     *
     * 3) Figure out a solution without code (Critical Thinking)
     *
     * 4) Write out our code
     * 5) Double check for errors, syntax or logic
     * 6) Test code with test cases
     * 7) Analysis
     *   Technique: BruteForce
     *   TimeComplexity : O(n^2)
     *   SpaceComplexity: O(n)
     *
     * 8) Can we optimize our solution?
     *
     *   Technique: Sliding Window
     *      Hint 1: Use a sliding window to represent the current substring
     *      Hint 2: The size of the window will change based on new characters,
     *              and characters we've already seen before
     *      Hint 3: Our seen characters hashmap keeps track of what characters
     *              we've seem, and the index we saw them at.
     *
     *   TimeComplexity : O(n)
     *   SpaceComplexity: O(n)
     *
     */


    public static int longestString(String s) {
        if (s == null) return 0;
        if (s.length() <= 1) return s.length();

        int left = 0, longest = 0;
        final Map<Character, Integer> seenChars = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            var currentChar = s.charAt(right);
            var prevSeenCharIndex = seenChars.get(currentChar);
            if (prevSeenCharIndex != null && prevSeenCharIndex >= left) {
                left = prevSeenCharIndex + 1;
            }
            seenChars.put(currentChar, right);
            longest = Math.max(longest, (right - left + 1));
        }
        return longest;
    }

    public static int longestStringBruteForce(String s) {
        if (s == null) return 0;
        if (s.length() <= 1) return s.length();

        int longest = 0;
        for (int left = 0; left < s.length(); left++) {
//            List<Character> seenChars = new ArrayList<>();//Contains method - more timeComplexity
            final Map<Character, Boolean> seenChars = new HashMap<>();
            int currentLength = 0;

            for (int right = left; right < s.length(); right++) {
                var currentChar = s.charAt(right);
                if (!seenChars.getOrDefault(currentChar, false)) {
                    currentLength++;
                    seenChars.put(currentChar, true);
                    longest = Math.max(longest, currentLength);
                }else {
                    break;
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestString(null));
        System.out.println(longestString(""));
        System.out.println(longestString("b"));
        System.out.println(longestString("abccabb"));
        System.out.println(longestString("cccccc"));
        System.out.println(longestString("abdcabe"));
    }

}

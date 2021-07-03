package edu.prahlad.zeroToMastery.string;

/**
 * Given a string, determine if it is almost a palindrome.
 * A string is almost a palindrome if it becomes a palindrome by removing 1 letter.
 * Consider only alphanumeric characters & ignore the sensitivity
 *
 * Leetcode
 * 680. Valid Palindrome II
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class AlmostValidPalindrome {
    /**
     * 0) Visualize the problem
     *
     * 1) Verify the constraints
     *      q) Do we consider a palindrome as almost a palindrome?
     *          Yes, return true if the string is already a palindrome
     *
     * 2) Write out some test cases
     *
     *      "aabaa"         true
     *      "raceacar"      true
     *      "abccdba"       true
     *      "abcdefdba"     false
     *      ""              true
     *      "a"             true
     *      "ab"            true
     *
     * 3) Figure out a solution without code (Critical Thinking)
     *
     * 4) Write our solution
     * 5) Double check for errors, syntax or code
     * 6) Test code with test cases
     * 7) Analysis (already optimised)
     *
     *    Technique: 2 pointers from outside
     *    TimeComplexity: O(n)
     *    SpaceComplexity: O(1)
     *
     */

    //2 pointers from outside
    public static boolean isAlmostPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        //initialize left/right pointers at start & end of string respectively
        int left = 0, right = s.length() - 1;

        //loop through string characters while comparing them,
        //then move the pointers closer to the center

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return (
                        validSubPalindrome(s.substring(left, right)) ||
                        validSubPalindrome(s.substring(left+1, right+1))
                );
            }

            left++;
            right--;
        }
        return true;
    }



    public static boolean validSubPalindrome(String s) {
        //initialize left/right pointers at start & end of string respectively
        int left = 0, right = s.length() - 1;

        //loop through string characters while comparing them,
        //then move the pointers closer to the center

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAlmostPalindrome("aabaa"));
        System.out.println(isAlmostPalindrome("raceacar" ));
        System.out.println(isAlmostPalindrome("abccdba"));
        System.out.println(isAlmostPalindrome("abcdefdba"));
        System.out.println(isAlmostPalindrome("a"));
        System.out.println(isAlmostPalindrome(""));
        System.out.println(isAlmostPalindrome("ab"));
    }
}

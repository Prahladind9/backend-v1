package edu.prahlad.zeroToMastery.string;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring case sensitivity
 *
 * Leetcode
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    /**
     * 0) Visualize the problem
     *
     * 1) Verify the constraints
     *      q) Does case sensitivity matter or non-alphanumeric?
     *      a) Already covered in question
     *
     * 2) Write out some test cases
     *
     *      "aabaa"         true
     *      "aabbaa"        true
     *      "abc"           false
     *      "a"             true
     *      ""              true
     *      "A man, a plan, a canal: Panama" ~ "amanaplanacanalpanama" ~ true
     *
     * 3) Figure out a solution without code (Critical Thinking)
     *
     * 4) Write out our code
     * 5) Double check for errors, syntax or logic
     * 6) Test code with test cases
     * 7) Analysis
     *    Technique: BruteForce - compare against reverse
     *    TimeComplexity: O(n)
     *    SpaceComplexity: O(n)
     *
     * 8) Can we optimize our solution?
     *      Multiple Technique's to solve the problem - same complexity
     *
     *      Technique 1: 2 pointers from center
     *      Technique 2: 2 pointers from outside
     *
     *      TimeComplexity : O(n)
     *      SpaceComplexity: O(1)
     *
     */



    //2 pointers from center
    public static boolean isValidPalindrome1(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        //initialize left/right pointers to point at the middle index of the string.
        //Remember, indexes start at 0 meaning that we have to floor() the value
        // from dividing length by 2 in order to get the index of the center.

        int left = Math.floorDiv(s.length(),2);
        int right = left;

        //if string is even, move left pointer back by 1
        // so left/right are pointing at the 2 middle values respectively
        if(s.length() % 2 ==0) {
            left--;
        }

        //loop through the string while expanding pointers outwards comparing the characters.
        while (left >=0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left--;
            right++;
        }
        return true;
    }

    //2 pointers from outside
    public static boolean isValidPalindrome2(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

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

    //compare against reverse
    public static boolean isValidPalindromeBF(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        StringBuilder rev = new StringBuilder();

        //generate a reverse string using a reverse loop
        for (int i = s.length()-1; i >= 0; i--) {
            rev.append(s.charAt(i));
        }
        return rev.toString().equals(s);
    }

    public static void main(String[] args) {
        System.out.println(isValidPalindrome1("aabaa"));
        System.out.println(isValidPalindrome1("aabbaa" ));
        System.out.println(isValidPalindrome1("abc"));
        System.out.println(isValidPalindrome1("a"));
        System.out.println(isValidPalindrome1(""));
        System.out.println(isValidPalindrome1("A man, a plan, a canal: Panama"));
    }
}

package edu.prahlad.zeroToMastery.string;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal
 * when both are typed out.
 * Any '#' that appears in the string counts as a backspace
 *
 * LeetCode
 * 844. Backspace String Compare
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class BackspaceStringCompare {

    /**
     * 0) Visualize the question
     *      i/p: S, T
     * 1) Verify the constraints
     *      a) What happens when two #'S appear beside each other?
     *          Delete the two values before the first #
     *          "ab##" => "",
     *      b) What happens to # when there is no character to remove?
     *          It deletes nothing then, just like backspace would.
     *          "a###c" => "c"
     *      c) Are two empty strings equal to each other?
     *          Yes, consider two empty strings as equal
     *      d) Does case sensitivity matter?
     *          Yes it does, "a" does not equal "A".
     *
     * 2) Write out some test cases
     *      S           T           Result
     *      "ab#z"      "az#z"      true
     *      "abc#d"     "acc#c"     false
     *      "x#y#z#"    "a#"        true
     *      "a###b"     "b"         true
     *      "Ab#z"      "ab#z"      false
     *
     * 3) Figure out a solution without code (Critical Thinking)
     *
     *
     * 4) Write out our code
     * 5) Double check for errors, syntax or logic
     * 6) Test code with test cases
     * 7) Analysis
     *   Technique: BruteForce
     *   TimeComplexity : O(S+T) ~ O(n)
     *   SpaceComplexity: O(S+T) ~ O(n)
     *
     * 8) Can we optimize our solution?
     *
     * Hints
     *      a) Utilize the original strings
     *      b) Use the 2 pointer technique
     *      c) Start from the end of the strings!
     *
     *   Technique: 2 pointer
     *   TimeComplexity : O(n)
     *   SpaceComplexity: O(1)
     */

    public static boolean backSpaceStringCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }

    public static boolean backSpaceStringCompareOptimized(String S, String T) {
        int p1 = S.length() - 1, p2 = T.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (isCharEqualsHash(S, p1) || isCharEqualsHash(T, p2)) {
                if (isCharEqualsHash(S, p1)) {
                    int backCount = 2;
                    while (backCount > 0) {
                        p1--;
                        backCount--;
                        if (p1 < 0) break;
                        if (isCharEqualsHash(S, p1)) backCount += 2;
                    }
                } else {
                    int backCount = 2;
                    while (backCount > 0) {
                        p2--;
                        backCount--;
                        if (p2 < 0) break;
                        if (isCharEqualsHash(T, p2)) backCount += 2;
                    }
                }
            } else {
                if (S.charAt(p1) != T.charAt(p2)) {
                    return false;
                } else {
                    p1--;
                    p2--;
                }
            }
        }
        return true;
    }

    private static boolean isCharEqualsHash(String s, int p) {
        if (p < 0) return false;
        return s.charAt(p) == '#';
    }

    public static boolean backSpaceStringCompareBruteForce(String s, String t){
        return buildString(s).equals(buildString(t));
    }

    private static String buildString(String string){
        Stack<Character> ans = new Stack();
        for (char c: string.toCharArray()) {
            if(c != '#'){
                ans.push(c);
            }else{
                if(!ans.isEmpty()) ans.pop();
            }
        }

        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        System.out.println(backSpaceStringCompare("ab#z", "az#z"));
        System.out.println(backSpaceStringCompare("abc#d", "acc#c"));
        System.out.println(backSpaceStringCompare("x#y#z#", "a#"));
        System.out.println(backSpaceStringCompare("a###b", "b"));
        System.out.println(backSpaceStringCompare("Ab#z", "ab#z"));

        /**
         * true
         * false
         * true
         * true
         * false
         */
    }
}

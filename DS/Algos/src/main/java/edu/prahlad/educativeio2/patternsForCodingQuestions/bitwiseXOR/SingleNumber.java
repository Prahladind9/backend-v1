package edu.prahlad.educativeio2.patternsForCodingQuestions.bitwiseXOR;

/**
 * In a non-empty array of integers,
 * every number appears twice except for one, find that single number.
 *
 * Time: O(n)
 * Space: O(1)
 */
public class SingleNumber {
    public static int findSingleNumber(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num ^ arr[i];
        }
        return num;
    }

    public static void main( String args[] ) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}

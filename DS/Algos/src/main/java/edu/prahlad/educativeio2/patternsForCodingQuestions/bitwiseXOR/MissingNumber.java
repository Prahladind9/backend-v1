package edu.prahlad.educativeio2.patternsForCodingQuestions.bitwiseXOR;

/**
 * Given an array of n−1 integers in the range from 1 to n,
 * find the one number that is missing from the array.
 *
 * Time: O(n)
 * Space: O(1)
 */
public class MissingNumber {


    public static void main(String[] args) {
        int[] arr = new int[] { 1, 5, 2, 6, 4 };
        System.out.print("Missing number is: " + MissingNumber.findMissingNumber(arr));
    }

    private static int findMissingNumber(int[] arr) {
        int n = arr.length +1;
        //find sum of all numbers from 1 ot n;
        int x1 = 1;
        for (int i = 2; i <=n ; i++) {
            x1 = x1 ^ i;
        }

        //x2 represents XOR of all values in arr
        int x2 = arr[0];
        for (int i = 1; i < n-2; i++) {
            x2 = x2 ^ arr[i];
        }

        //missing number is the xor if x1 and x2
        return x1 ^ x2;
    }
}

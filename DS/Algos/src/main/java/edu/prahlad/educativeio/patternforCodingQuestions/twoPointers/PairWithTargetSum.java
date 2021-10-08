package edu.prahlad.educativeio.patternforCodingQuestions.twoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Q) Given an array of sorted numbers and a target sum,
 *    find a pair in the array whose sum is equal to the given target.
 *
 * TC: O(n)
 * SC: O(1)
 *
 * HashTable approach
 * TC: O(n)
 * SC: O(1)
 */
public class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum)
                return new int[] { left, right }; // found the pair

            if (targetSum > currentSum)
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
        return new int[] { -1, -1 };
    }

    public static int[] searchUsingHashTable(int[] arr, int targetSum) {
        Map<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(nums.containsKey(targetSum - arr[i])){
                return new int[]{nums.get(targetSum - arr[i]), i};
            }else{
                nums.put(arr[i], i);
            }

        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[]{1, 2, 3, 4, 6}, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[]{2, 5, 9, 11}, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");


        result = PairWithTargetSum.searchUsingHashTable(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.searchUsingHashTable(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}

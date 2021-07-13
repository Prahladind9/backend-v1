package edu.prahlad.zeroToMastery.array;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2,
 * sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function,
 * but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n,
 * where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * LeetCode
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class Merge2SortedArrays {

    /**
     * 0) Visualize the question
     * 1) Verify Constraints
     *     a) Should we create new array?
     *          No, assume 1st array to have enough capacity to hold both array elements
     * 2) Write out some test cases
     *     a) nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     *          [1,2,2,3,5,6]
     *     b) nums1 = [1], m = 1, nums2 = [], n = 0
     *          [1]
     *     c) nums1 = [0], m = 0, nums2 = [1], n = 1
     *          [1]
     *
     * 3) Figure out a solution without code
     * 4) Write our solution
     * 5) Double check for errors, syntax or logic
     * 6) Test out code with our test cases
     * 7) Analysis
     *   Technique: BruteForce
     *   TimeComplexity : O(n)
     *   SpaceComplexity: O(1)
     *
     * */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        m --;
        n --;
        for (int i = m + n + 1; i >=0; i --) {
            int a = m >=0 ? nums1[m]:Integer.MIN_VALUE;
            int b = n >=0 ? nums2[n]:Integer.MIN_VALUE;
            if (a > b) {
                nums1[i] = a;
                m --;
            }
            else {
                nums1[i] = b;
                n --;
            }
        }

        System.out.println("merged array "+ Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        merge(new int[]{1}, 1, new int[]{}, 0);
        merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}

package edu.prahlad.zeroToMastery.array;

/**
 * You are given two integer arrays nums1 and nums2,
 * sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * LeetCode
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class Merge2SortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
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
    }
}

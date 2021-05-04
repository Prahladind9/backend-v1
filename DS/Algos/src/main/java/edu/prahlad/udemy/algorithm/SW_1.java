package edu.prahlad.udemy.algorithm;

public class SW_1 {
    /**
     * Write a function called maxSubnumsaySum which accepts an numsay of integers
     * and a number called n.
     * The function should calculate the maximum sum of n consecutive elements in the numsay
     */

    //Naive Solution - O(n`2)
    //Sliding window - O(n)
    private static final int maxSubnumsaySum(final int[] nums, final int num){
        if(nums.length < num) return 0;
        int maxSum = 0;
        int tempSum = 0;
        for (int i = 0; i < num; i++) {
            maxSum += nums[i];
        }
        tempSum = maxSum;

        for (int i = num; i < nums.length; i++) {
            tempSum = tempSum - nums[i-num] + nums[i];
            maxSum = Math.max(tempSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubnumsaySum(new int[]{2,6,7,3,6,7,3,7,3,9,23}, 3));
    }

}

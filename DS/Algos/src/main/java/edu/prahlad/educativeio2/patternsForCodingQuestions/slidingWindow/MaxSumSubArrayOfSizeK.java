package edu.prahlad.educativeio2.patternsForCodingQuestions.slidingWindow;

/**
 * Given an array of positive numbers and a positive number ‘k,’
 * find the maximum sum of any contiguous subarray of size ‘k’.
 *
 * Time: O(n)
 * Space: O(1)
 */
public class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; //add the next element
            //slide the window, we don't need to slide it we've not hit the required window size of 'k'
            if(windowEnd >= k -1){
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; //subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
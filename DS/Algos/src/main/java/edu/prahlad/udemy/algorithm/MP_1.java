package edu.prahlad.udemy.algorithm;

public class MP_1 {
    /**
     * Write a function called sumZero which accepts sorted array of integers.
     * The function should find the first pair where the sum is 0.
     * Return an array that includes both values that sum to zero or undefined if
     * a pair does not exist.
     *
     * sumZero([-3, -2,2,3]) //[-3,3]
     * sumZero([1,2,3]) //undefined
     */

    //Naive Solution
    // using 2 for loops
    // TimeComplexity O(n`2)
    // SpaceComplexity O(1)

    //Multiple Pointers Solution - O(n)
    private static final int[] sumZero(final int[] arr){
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == 0){
                System.out.println("Pair " + arr[left] +" & "+ arr[right]);
                return new int[]{arr[left], arr[right]};
            }else if(sum > 0){
                right--;
            }else {
                left++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        sumZero(new int[]{-3,-2, 2, 3});
        sumZero(new int[]{-4,-2, 2, 3});
        sumZero(new int[]{-5,-3,-2, 2, 3,5,9});
    }
}

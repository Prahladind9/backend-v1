package edu.prahlad.udemy.algorithm;

public class DC_1 {
    /**
     * Given a sorted array of integers, write a function called search,
     * that accepts a value and returns the index where the value passed to the
     * function is located.
     * If the value is not found, return -1
     */

    //Naive Soln - Linear Search O(n)
    //DC Soln - Binary Search O(log(n))

    private static final int search(final int[] arr, final int val){
        int min = 0;
        int max = arr.length -1;

        while (min <= max){
            int middle = (((min + max)/2));
            int currentElement = arr[middle];
            if(arr[middle] < val){
                min = middle + 1;
            }else if(arr[middle] > val){
                max = middle -1;
            }else {
                return middle;
            }
        }

        return  -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,4,6,9,12,34,56,78}, 34));
    }
}

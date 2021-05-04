package edu.prahlad.udemy.algorithm;

public class MP_2 {
    /**
     * CountUniqueValues - works only sorted array
     * Implement a function called countUniqueValues, which accepts a sorted array,
     * and counts the unique values in the array
     * There can be negative numbers in the array, but it will always be sorted
     */

    //O(n)
    private static final int countUniqueValues(final int[] arr){
        if(arr.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j <arr.length; j++) {
            if(arr[i] != arr[j]){
                i++;
            }
        }
        return i+1;
    }

    //O(n)
    private static final int countUniqueValuesChainingArray(final int[] arr){
        if(arr.length == 0)
            return 0;

        int i = 0;
        for (int j = 1; j <arr.length; j++) {
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        System.out.println(countUniqueValues(new int[]{1,1,1,3,5}));
        System.out.println(countUniqueValues(new int[]{1,2,3,4,4,5,6,8,9}));
        System.out.println(countUniqueValues(new int[]{1,2,3,4,4,5,6,8,9}));
    }
}

package edu.prahlad.udemy.sort;

import java.util.Arrays;

public class BubbleSort {

    //best case O(n) - Avg O(n^2)
    private static final int[] bubbleSortOptimized(int[] arr){
        for (int i = arr.length; i > 0; i--) {
            boolean noSwaps = true;
            for (int j = 0; j < i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    noSwaps = false;
                }
            }
            if(noSwaps) break;
        }
        return arr;
    }

    //best & Avg case O(n^2)
    private static final int[] bubbleSortNaive(int[] arr){
        for (int i = arr.length; i > 0; i--) {
            for (int j = 0; j < i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSortNaive(new int[]{3,1,7,4,2})));
        System.out.println(Arrays.toString(bubbleSortOptimized(new int[]{3,1,7,4,2})));
    }
}

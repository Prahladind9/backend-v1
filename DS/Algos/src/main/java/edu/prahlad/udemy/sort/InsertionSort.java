package edu.prahlad.udemy.sort;

import java.util.Arrays;

public class InsertionSort {

    //Avg & worst  O(n^2)
    private static final int[] insertionSort(int[] input){
        for (int i = 1; i < input.length; i++) {
            int key = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = key;
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{3,1,7,4,2})));
    }
}

package edu.prahlad.udemy.sort;

import java.util.Arrays;

public class SelectionSort {

    //O(n^2)
    private static final int[] selectionSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int lowest = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[lowest]) lowest = j;
            }

            if(lowest != i){
                int temp = arr[i];
                arr[i] = arr[lowest];
                arr[lowest] = temp;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[]{3,1,7,4,2})));
    }
}

package edu.prahlad.udemy.sort;

import java.util.Arrays;

public class QuickSort {

    //Time: best & avg O(nlog(n)), worst - O(n^2) Space: O(log(n))
    private static final int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = QuickPivotHelper.pivot(arr, left, right);
            //left
             quickSort(arr, left, pivotIndex - 1);
            //right
             quickSort(arr, pivotIndex + 1, right);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{5, 8, 12, 4, 3, 1, 66, 89, 6}, 4, 9)));
    }
}

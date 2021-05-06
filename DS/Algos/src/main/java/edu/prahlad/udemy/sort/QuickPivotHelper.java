package edu.prahlad.udemy.sort;

import java.util.Arrays;

public class QuickPivotHelper {

    /**
     * Pivot Helper
     *
     * @param arr  array
     * @param left pivotIndex we are passing
     * @param right  length of array
     * @return pivoted index
     */
    public static final int pivot(int[] arr, int left, int right) {
        int pivot = arr[left];
        int swapIdx = left;

        for (int i = left + 1; i < arr.length; i++) {
            if (pivot > arr[i]) {
                swapIdx++;
                arr = swap(arr, swapIdx, i);
            }
        }

        arr = swap(arr, left, swapIdx);
        System.out.println(Arrays.toString(arr));
        return swapIdx;
    }

    private static final int[] swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(pivot(new int[]{1, 2, 4, 78, 9, 3}, 2, 6));

    }
}

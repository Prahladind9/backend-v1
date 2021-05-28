package edu.prahlad.CodeWithMosh.part3.sorting;

import java.util.Arrays;

/**
 * Best    Worst
 * Passes       O(1)    O(n)
 * Comparisons  O(n)    O(n)
 * Total        O(n)    O(n^2)
 * Linear  Quadratic
 */
public class BubbleSort {
    public void bubbleSort(int[] array) {
        boolean isSorted;
        for (int i = 0; i < array.length; i++) {
            isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            }
            if (isSorted)
                return;
        }
    }

    private void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {83, 1, 3, 5, 3, 6};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}

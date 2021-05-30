package edu.prahlad.CodeWithMosh.part3.sorting;

import java.util.Arrays;

/**
 * Best    Worst
 * Passes       O(n)    O(n)
 * Comparisons  O(n)    O(n)
 * Total        O(n^2)  O(n^2)
 * Quadratic  Quadratic
 */
public class SelectionSort implements Sort {
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            var minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            swap(array, minIndex, i);
        }
    }
}

package edu.prahlad.codeWithMosh.part3.sorting;

/**
 * Best    Worst
 * Passes       O(1)    O(n)
 * Comparisons  O(n)    O(n)
 * Total        O(n)    O(n^2)
 * Linear  Quadratic
 */
public class BubbleSort implements Sort {
    public void sort(int[] array) {
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
}

package edu.prahlad.CodeWithMosh.part3.sorting;

/**
 *              Best    Worst
 * Passes       O(n)    O(n)
 * Comparisons  O(1)    O(n)
 * Total        O(n)    O(n^2)
 *              Linear  Quadratic
 */
public class InsertionSort implements Sort {
    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            var current = array[i];
            var j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }
}

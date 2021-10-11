package edu.prahlad.codeWithMosh.part3.sorting;

/**
 *              Best        Worst
 * Partitioning O(n)        O(n)
 * # of items   O(log n)    O(n)
 * Total        O(n log n)  O(n^2)
 * <p>
 * Space        O(log n)     O(n)
 */
public class QuickSort implements Sort {
    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int start, int end) {
        //base case
        if (start >= end) return;

        //partition
        var boundary = partition(array, start, end);
        //sort left
        sort(array, start, boundary - 1);
        //sort right
        sort(array, boundary + 1, end);
    }

    private int partition(int[] array, int start, int end) {
        var pivot = array[end];
        var boundary = start - 1;
        for (int i = start; i <= end; i++) {
            if (array[i] <= pivot)
                swap(array, i, ++boundary);
        }

        return boundary;
    }
}

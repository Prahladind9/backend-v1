package edu.prahlad.CodeWithMosh.part3.sorting;

/**
 * Time memory trade-off
 *
 * Preq: All positive elements in the array &
 *       max element should be valid
 * Space: O(k), k distinct elements of an array
 * Time:
 *  populate counts     O(n)
 *  iterative counts    O(k)
 *          Total       O(n)
 *
 */
public class CountingSort {

    public void sort(int[] array, int max){
        int[] counts = new int[max+1];
        for (var item: array)
            counts[item]++;

        int k =0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                array[k++] = i;
            }
        }
    }
}

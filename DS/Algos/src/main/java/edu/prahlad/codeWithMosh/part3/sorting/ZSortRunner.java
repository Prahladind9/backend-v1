package edu.prahlad.codeWithMosh.part3.sorting;

import java.util.Arrays;

public class ZSortRunner {
    public static void main(String[] args) {
        int[] numbers = {8, 1, 3, 5, 8, 6, 19};
//        var sorter = new BubbleSort();
//        var sorter = new SelectionSort();
//        var sorter = new InsertionSort();
//        var sorter = new MergeSort();
//        var sorter = new QuickSort();
//        sorter.sort(numbers);

//        var sorter = new CountingSort();
//        sorter.sort(numbers, 20);
        var sorter = new BucketSort();
        sorter.sort(numbers, 6);
        System.out.println(Arrays.toString(numbers));
    }
}

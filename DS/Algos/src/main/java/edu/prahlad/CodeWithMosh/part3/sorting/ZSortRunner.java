package edu.prahlad.CodeWithMosh.part3.sorting;

import java.util.Arrays;

public class ZSortRunner {
    public static void main(String[] args) {
        int[] numbers = {83, 1, 3, 5, 6};
//        var sorter = new BubbleSort();
        var sorter = new SelectionSort();
        sorter.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}

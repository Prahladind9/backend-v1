package edu.prahlad.udemy.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeHelper {

    public static final List<Integer> mergeArrayListHelper
            (List<Integer> arr1,
             List<Integer> arr2) {

        List<Integer> arr = new ArrayList<>(arr1.size() + arr2.size());
        int i = 0;
        int j = 0;
        while (i < arr1.size() && j < arr2.size()){
            if(arr2.get(j) > arr1.get(i)){
                arr.add(arr1.get(i));
                i++;
            } else {
                arr.add(arr2.get(j));
                j++;
            }
        }

        while (i < arr1.size()){
            arr.add(arr1.get(i));
            i++;
        }

        while (j < arr2.size()){
            arr.add(arr2.get(j));
            j++;
        }

        return arr;
    }

    public static final int[] mergeArrayHelper(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int counter = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr2[j] > arr1[i]) {
                arr[counter] = arr1[i];
                i++;
            } else {
                arr[counter] = arr2[j];
                j++;
            }
            counter++;
        }

        while (i < arr1.length) {
            arr[counter] = arr1[i];
            counter++;
            i++;
        }

        while (j < arr2.length) {
            arr[counter] = arr2[j];
            counter++;
            j++;
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeArrayHelper(new int[]{1, 4, 6}, new int[]{5, 8, 12})));
    }
}

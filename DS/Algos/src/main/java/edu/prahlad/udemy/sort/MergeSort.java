package edu.prahlad.udemy.sort;

import java.util.Arrays;
import java.util.List;

public class MergeSort {

    //Time Best-avg-worst > O(nlog(n)) & Space O(n)
    private static final List<Integer> mergeSortArrayList(List<Integer> arr){
        if(arr.size() <=1) return arr; //Base Condition
        int mid = arr.size()/2;
        //Recursive condition
        List<Integer> left = mergeSortArrayList(arr.subList(0, mid));
        List<Integer> right = mergeSortArrayList(arr.subList(mid, arr.size()));
        return MergeHelper.mergeArrayListHelper(left, right);
    }

    private static final int[] mergeSortArray(int[] arr) {
         if(arr.length <=1) return arr;
         int mid = arr.length /2;
         int[] left = new int[mid];
         int[] right = new int[arr.length-mid];

         //Split array into 2 slice
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        //System.out.println("Before" + Arrays.toString(left));
        left = mergeSortArray(left);
        //System.out.println("After" + Arrays.toString(left));

        for (int i = 0; i < arr.length-mid; i++) {
            right[i] = arr[mid+i];
        }
        //System.out.println("Before" + Arrays.toString(right));
        right = mergeSortArray(right);
        //System.out.println("After" + Arrays.toString(right));

        return MergeHelper.mergeArrayHelper(left, right);
    }


    public static void main(String[] args) {
        System.out.println(mergeSortArrayList(Arrays.asList(5,8,12,4,3,1,66,89,6)));
        //System.out.println(Arrays.toString(mergeSortArray(new int[]{5,8,12,4,3,1,66,89,6})));

    }
}

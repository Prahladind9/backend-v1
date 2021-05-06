package edu.prahlad.udemy.search;

public class LinearSearch {

    //TimeComplex > O(1) best > O(n) worst & average
    private static final int linearSearch(int[] arr, int val){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == val)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Index " + linearSearch(new int[]{3, 1, 2, 9, 5, 7, 12},3));
    }
}

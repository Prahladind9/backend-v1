package edu.prahlad.udemy.search;

public class BinarySearch {
    //O(1) best case - O(log(n)) worst & avg case
    private static final int binarySearch(int[] arr, int val){
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == val) {
                return mid;
            }else if(arr[mid] < val){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Index " + binarySearch(new int[]{1,2,3},3));
        System.out.println("Index " + binarySearch(new int[]{1,2,3,4,8,9,23},9));
    }
}

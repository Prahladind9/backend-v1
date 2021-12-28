package edu.prahlad.educativeio2.patternsForCodingQuestions.modifiedBinarySearch;

/**
 * Given a sorted array of numbers, find if a given number ‘key’ is present in the array.
 * Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order.
 * You should assume that the array can have duplicates.
 *
 *
 * Time: O(logN)
 * Space: O(1)
 */
public class OrderAgnosticBinarySearch {

    public int search(int[] arr, int key) {
        int start = 0, end = arr.length -1;
        boolean isAscending = arr[start] < arr[end];
        while (start <= end){
            //mid value for the given range
            int mid = start + (end-start)/2;
            if(key == arr[mid])
                return mid;

            if(isAscending){
                if(key < arr[mid]){
                    end = mid-1;
                }else {
                    start = mid +1;
                }
            }else {
                if(key > arr[mid]){
                    end = mid-1;
                }else {
                    start = mid + 1;
                }
            }
        }

        return -1; //element not found
    }

    public static void main(String[] args) {
        var binarySearch = new  OrderAgnosticBinarySearch();
        System.out.println(binarySearch.search(new int[] { 4, 6, 10 }, 10));
        System.out.println(binarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        System.out.println(binarySearch.search(new int[] { 10, 6, 4 }, 10));
        System.out.println(binarySearch.search(new int[] { 10, 6, 4 }, 4));
    }
}

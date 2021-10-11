package edu.prahlad.educativeio.patternforCodingQuestions.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers,
 * find "all" unique triplets in it that add up to zero.
 *
 * TC: O(n^2), Sorting Array: O(n * log(n)), searchPair: O(n), for loop on searchPair: O(n) ==> ((n * log(n)) + n^2)
 * SC: O(n)
 *
 */
public class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if(i>0 && arr[i] == arr[i-1])
                continue;

            searchPair(arr, -arr[i], i +1, triplets);
        }
        return triplets;
    }

    //-X = Y + Z
    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets){
        int right = arr.length -1;
        while (left < right){
            int currentSum = arr[left] + arr[right];
            if(currentSum == targetSum){ //found triplet
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;

                while (left < right && arr[left] == arr[left-1])
                    left++; //skip same element to avoid duplicate triplets, left side

                while (left < right && arr[right] == arr[right+1])
                    right--; //skip same element to avoid duplicate triplets, right side

            }else if(targetSum > currentSum){
                left++;
            }else{
                right--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}

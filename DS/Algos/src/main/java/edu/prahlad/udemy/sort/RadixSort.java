package edu.prahlad.udemy.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RadixSort {

    //Time O(nk)   n length of array
    //             k number of digits
    //Space O(n+k)
    private static final List<Integer>  radixSort(List<Integer> nums){
        int maxDigitCount = RadixHelper.mostDigits(nums);
        for (int i = 0; i < maxDigitCount-1; i++) {
            List<List<Integer>> digitBuckets = RadixHelper.getList();
            for (int j = 0; j < nums.size(); j++) {
                int digit = RadixHelper.getDigit(nums.get(j), i);
                digitBuckets.get(digit).add(nums.get(j));
            }
            nums = digitBuckets.stream()
                    .flatMap(list -> list.stream())
                    .collect(Collectors.toList());
            System.out.println(nums);
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(radixSort(Arrays.asList(13445,448,67,46876,966845)));
    }
}

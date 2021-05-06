package edu.prahlad.udemy.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixHelper {
    public static final int getDigit(int num, int i){
        return (int) (Math.floor(Math.abs(num)/Math.pow(10,i)) % 10);
    }

    public static final int mostDigits(int[] nums){
        int maxDigits = 0;
        for (int i = 0; i < nums.length; i++) {
            maxDigits = Math.max(maxDigits, digitCount(nums[i]));
        }
        return maxDigits;
    }

    public static final int mostDigits(List<Integer> nums){
        int maxDigits = 0;
        for (int i = 0; i < nums.size(); i++) {
            maxDigits = Math.max(maxDigits, digitCount(nums.get(i)));
        }
        return maxDigits;
    }

    public static int findMaximumNumberIn(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    private static final int digitCount(int num){
        if(num ==0) return 1;
        return (int) Math.floor(Math.log10(Math.abs(num))) + 1;
    }

    public static List<List<Integer>> getList() {
        List<List<Integer>> digitBuckets = new ArrayList<>(10);
        digitBuckets.add(new ArrayList<>());
        digitBuckets.add(new ArrayList<>());
        digitBuckets.add(new ArrayList<>());
        digitBuckets.add(new ArrayList<>());
        digitBuckets.add(new ArrayList<>());
        digitBuckets.add(new ArrayList<>());
        digitBuckets.add(new ArrayList<>());
        digitBuckets.add(new ArrayList<>());
        digitBuckets.add(new ArrayList<>());
        return digitBuckets;
    }

    public static void main(String[] args) {
        System.out.println(getDigit(7323,2));
        System.out.println(mostDigits(new int[]{1,23453,56333,232,3}));
        System.out.println(digitCount(7323));
    }
}

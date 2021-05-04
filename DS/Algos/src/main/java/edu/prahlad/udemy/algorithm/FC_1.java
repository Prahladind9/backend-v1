package edu.prahlad.udemy.algorithm;

import java.util.HashMap;
import java.util.Map;

public class FC_1 {
    /**
     * Write a function called same, which accepts two arrays.
     * The function should return true if every value in the array has
     * it's corresponding value squared in the second array
     * The frequency of values must be the same.
     */

    //Native Solution - 2 for loops - O(n`2)

    //Frequency Counter Solution - O(n)
    private static boolean same(final int[] a1, final int[] a2){
        if(a1.length != a2.length)
            return false;

        final Map<Integer, Integer> m1 = new HashMap();
        final Map<Integer, Integer> m2 = new HashMap();

        for (int i = 0; i < a1.length; i++) {
            m1.put(a1[i], m1.getOrDefault(a1[i], 0)+1);
        }
        System.out.println("m1 " + m1);

        for (int i = 0; i < a2.length; i++) {
            m2.put(a2[i], m2.getOrDefault(a2[i], 0)+1);
        }
        System.out.println("m2 " + m2);

        for (Integer val: m1.keySet()){
            if(!m2.containsKey(val * val))
                return false;

            if(m2.get(val * val) != m1.get(val))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,2,2};
        int[] arr2 = {1,4,9,4,4};
        System.out.println("The 2 arrays satisfy condition - " + same(arr1, arr2));
    }
}

package edu.prahlad.udemy.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class R_4 {

    //Helper Recursion
    private static List<Integer> res = new ArrayList<>();
    private static final List<Integer> collectOddValues(List<Integer> arr) {
        helper(arr);
        return res;
    }

    private static final void helper(List<Integer> arr) {
        if (arr.size() == 0)
            return;

        if (arr.get(0) % 2 != 0)
            res.add(arr.get(0));

        helper(arr.subList(1, arr.size()));
    }

    public static void main(String[] args) {
        System.out.println(collectOddValues(Arrays.asList(1, 2, 3, 4)));
    }
}

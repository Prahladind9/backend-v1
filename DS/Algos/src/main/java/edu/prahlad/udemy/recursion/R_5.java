package edu.prahlad.udemy.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class R_5 {

    //Pure Recursion
    private static final List<Integer> collectOddValues(List<Integer> arr) {
        List<Integer> newArr = new ArrayList<>();
        if(arr.size() == 0)
            return newArr;

        if(arr.get(0) % 2 != 0)
            newArr.add(arr.get(0));

        newArr.addAll(collectOddValues(arr.subList(1, arr.size())));
        return newArr;
    }

    public static void main(String[] args) {
        System.out.println(collectOddValues(Arrays.asList(1, 2, 3, 4)));
    }
}

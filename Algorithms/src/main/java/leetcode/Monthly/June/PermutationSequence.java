package leetcode.Monthly.June;

import leetcode.learn.DataStructures.Shared.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        String[] a = {"231","312","321", "123", "132", "213"};

        Arrays.sort(a);
        Helper.printStringArray(a);

        PermutationSequence permutationSequence = new PermutationSequence();
        permutationSequence.generatePermutationSequenceArray(3);

        System.out.println();
    }

    public String getPermutation(int n, int k) {
        return "";

    }

    private String[] generatePermutationSequenceArray(int noOfDigits){
        int arraySize = 1;
        String permValue = "";
        for(int i=1; i <= noOfDigits; i++){
            arraySize = arraySize * i;
            permValue = permValue + i;
        }

        List<String> permutationSequenceArray = new ArrayList<>(arraySize);



//        for(int i=0; )

        Collections.sort(permutationSequenceArray);
        return null;
    }
}

package leetcode.learn.DataStructures.ArraysAndString.Array;

import leetcode.learn.DataStructures.Shared.Helper;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
//        int[] nums = {1,7,3,6,5,9};
        int[] nums = {9,7,3,6,5,9};
//        int[] nums = {0};
//        int[] nums = {1,7,3};
//        int[] nums = {1};
//        int[] nums = {-1,-1,-1,0,1,1};
        Helper.printIntArray(plusOne.plusOne(nums));

    }

    public int[] plusOne(int[] digits) {


        //Work out on the edges cases and at least 5 inputs cases

        //oracle.Quiz.oracle.Soln
        // all9's Boolean flag
        // go through the list of nums ..
        // if all have 9 then get ready for new array
        //  with length[existing length + 1]
        //      and 0th index will be 1 and rest all 0's
        // else
        // add one to last index value
        //      if number is 9 then replace with 0 proceed to next value
        //      else update the index value with the number
        //          and break out of the loop

        boolean all9s = false;
        for(int val: digits){
            if(val == 9){
                all9s = true;
            }else {
                all9s = false;
            }
            if(!all9s){
                break;
            }
        }

        if(all9s){
            int[] newDigitsArray = new int[digits.length+1];
            newDigitsArray[0] = 1;
            for (int i=1; i < newDigitsArray.length; i++){
                newDigitsArray[i] = 0;
            }

            return newDigitsArray;
        }else {
            boolean addNextIndex = false;
            for (int i=digits.length-1; i >= 0; i--){
                if(digits[i] == 9){
                    digits[i] = 0;
                    addNextIndex = true;
                }else {
                    digits[i] = digits[i] +1;
                    addNextIndex = false;
                }

                if(!addNextIndex){
                    break;
                }
            }
            return digits;
        }


    }
}

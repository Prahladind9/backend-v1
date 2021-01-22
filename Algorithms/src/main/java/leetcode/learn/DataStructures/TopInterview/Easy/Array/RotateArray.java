package leetcode.learn.DataStructures.TopInterview.Easy.Array;

import DataStructures.Shared.Helper;

public class RotateArray {

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
//       int[] nums = {1,2,3,4,5,6,7};
       int[] nums = {1,2};
       int k = 3;
       rotateArray.rotate(nums,k);
    }

    public void rotate(int[] nums, int noOfSteps) {
        //rotate right by noOfSteps
        //length of array - noOfSteps will be the first index
        if(noOfSteps ==0){
            return;
        }
        if(nums.length ==1){
            return;
        }
        //Edge Case
        //noOfSteps is greater than Length .. means
        // after move ... array will reach original state and then the extra steps ...
        // to avoid un necessary movement we'll use the  noOfSteps = noOfSteps - nums.length;
        if(noOfSteps > nums.length){
            noOfSteps = noOfSteps - nums.length;
        }

        //3 Step
        //1) temp array .. store the end values to be moved
        int[] temp = new int[noOfSteps];
        for(int i=0; i< noOfSteps; i++){
            temp[i] = nums[nums.length - noOfSteps + i];
        }
        Helper.printIntArray(temp);

        //2) original array .. assign the values as per the requested steps
        for(int i=nums.length-1; i >= noOfSteps; i--){
            nums[i] = nums[i-noOfSteps];
        }
        Helper.printIntArray(nums);

        //3) Using temp, replace the values of the original array
        for(int i =0; i< noOfSteps; i++){
            nums[i] = temp[i];
        }
        Helper.printIntArray(nums);
    }
}

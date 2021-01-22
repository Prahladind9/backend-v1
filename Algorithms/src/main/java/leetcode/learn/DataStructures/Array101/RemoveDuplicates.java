package leetcode.learn.DataStructures.Array101;

import leetcode.learn.DataStructures.Shared.Helper;

import java.util.Random;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3248/
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        /*removeDuplicates.removeDuplicates(new int[]{1,2,2});
        removeDuplicates.removeDuplicates(new int[]{1,2});
        removeDuplicates.removeDuplicates(new int[]{1,1,2});*/
        removeDuplicates.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return 1;
        }

        /**
         * We'll keep track of the unique elements in the given sorted array
         * uniqueCount, startIndex, uniqueIndex
         * if uniqueIndex == startIndex then do nothing
         *  else uniqueIndex != startIndex or uniqueIndex - startIndex >=1
         *      then  nums[startIndex+1] = nums[i+1];
         */

        int uniqueCount = 1;
        int startIndex = 0;
        int uniqueIndex = 0;

        for(int i = 0; i < nums.length -1; i++){
            if(nums[i] != nums[i+1]){
                ++uniqueCount;
                uniqueIndex = i+1;
                if(uniqueIndex - startIndex >= 1){
                    nums[startIndex+1] = nums[i+1];
                    ++startIndex;
                }
            }
        }

        if(uniqueCount == nums.length){
            return uniqueCount;
        }
        for(int k = startIndex+1; k < nums.length; k++){
            nums[k]= 0;
        }

        System.out.println(uniqueCount);
        Helper.printIntArray(nums);
        return uniqueCount;
    }

    public int removeDuplicates2(int[] nums) {
        if(nums.length ==1){
            return 1;
        }
        int length = nums.length;
        for(int i=0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                int k = 0;
                for(k=i; k < nums.length -2; k++){
                    nums[k+1] = nums[k+2];
                }
                nums[k+1] = new Random().nextInt(Integer.MAX_VALUE);
                --length;
                --i;
            }
        }

        System.out.println(length);
        Helper.printIntArray(nums);
        return length;
    }
}

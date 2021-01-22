package leetcode.learn.DataStructures.Array101;

import java.util.Arrays;

public class ThirdMax {
    public static void main(String[] args) {
        ThirdMax thirdMax = new ThirdMax();
        thirdMax.thirdMax(new int[]{3, 2, 1});
        thirdMax.thirdMax(new int[]{1, 1, 2});
        thirdMax.thirdMax(new int[]{ 2, 1});
        thirdMax.thirdMax(new int[]{3, 2, 2, 1});


        //edgeCases
        //01
        //1
        //1111
        //222122
        //000311111
        //123445252289

    }

    public int thirdMax(int[] nums) {
        if(nums.length == 0)
            return 0;

        if(nums.length == 1)
            return nums[0];

        if(nums.length == 2)
            return nums[1] > nums[0] ? nums[1] : nums[0];

        int maxCounter = 0;
        int thirdMaxIndex =0;
        Arrays.sort(nums);

        for(int i= nums.length-1; i>=1; i--){
            if(nums[i] > nums [i-1]) {
                ++maxCounter;
                thirdMaxIndex= i;
            }
            if(maxCounter ==2) {
                break;
            }else{
                thirdMaxIndex = nums.length;
            }


        }
        System.out.println(nums[thirdMaxIndex-1]);
        return nums[thirdMaxIndex-1];

    }
}

package leetcode.learn.DataStructures.TopInterview.Easy.Array;

import java.util.Arrays;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate  =new ContainsDuplicate();
        int[] a = {1,2,3,1};
        System.out.println( containsDuplicate.containsDuplicate(a));
    }

    public boolean containsDuplicate(int[] nums) {
        if(nums.length ==1){
            return false;
        }

        Arrays.sort(nums);
        for (int i=1; i < nums.length; i++){
            if (nums[i] == nums[i-1])
                return true;
        }

        return false;
    }
}

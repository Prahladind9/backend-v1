package leetcode.learn.DataStructures.Array101;

import leetcode.learn.DataStructures.Shared.Helper;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
//        removeElement.removeElement(new int[]{3, 2, 2, 3}, 3);
//        removeElement.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
        removeElement.removeElement(new int[]{4, 4, 0, 1, 0, 2}, 0);

    }

    private int removeElement(int[] nums, int val) {
        int length = nums.length;

//        No Need for this condition, there's compulsory input
//        if(length == 0){
//            return 0;
//        }

        //if val meets in the array .. move elements to the left and assign last value as Integer.Max_value

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int k = i; k < nums.length - 1; k++) {
                    nums[k] = nums[k + 1];
                }
                nums[length - 1] = Integer.MAX_VALUE;
                --length;
                --i;
            }
        }
        System.out.println(length);
        Helper.printIntArray(nums);
        return length;
    }
}

package leetcode.learn.DataStructures.ArraysAndString.Array;

public class LargestNumberAtLeastTwiceofOthers {
    public static void main(String[] args) {
        LargestNumberAtLeastTwiceofOthers largestNumberAtLeastTwiceofOthers = new LargestNumberAtLeastTwiceofOthers();
//        int[] nums = {1,7,3,6,5,6};
        int[] nums = {3, 6, 1, 0};
//        int[] nums = {2,0,0,3};
//        int[] nums = {1};
//        int[] nums = {-1,-1,-1,0,1,1};
        System.out.println(largestNumberAtLeastTwiceofOthers.dominantIndex(nums));
    }

    public int dominantIndex(int[] nums) {
        //Largest Number At Least Twice of Others in the array
        //Find the largest element ...
        //   ***taking note that there's always only one unique max element
        //  sort and get max index? NOO
        // manual loop and get the value ... cannot change the position of the index values

        //largestElement
        // 1 elements then 0
        // Loop through the elements .. except the largest ...
        //
        //
        // check whether the index val twice is > and largestElement is not the current index value..
        // yes then -1 .. else the


//        if (nums == null)
//            return -1;
//
        if(nums.length == 1)
            return 0;

        int largestElement = nums[0];
        int largestElementIndex = 0;

        for(int i = 1; i< nums.length; i++){
            if(nums[i] > largestElement){
                largestElement = nums[i];
                largestElementIndex = i;
            }
        }


        for(int i = 0; i< nums.length; i++){
            if(largestElement != nums[i] && nums[i] * 2 > largestElement){
                return -1;
            }
        }

        return largestElementIndex;
    }
}

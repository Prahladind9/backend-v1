package leetcode.learn.DataStructures.ArraysAndString.Array;

public class PivotIndex {
    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();
        int[] nums = {1,7,3,6,5,6};
//        int[] nums = {1,7,3};
//        int[] nums = {1};
//        int[] nums = {-1,-1,-1,0,1,1};
        System.out.println(pivotIndex.pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        //Pivotal Index .. exempting the value of the pivotIndex
        // *left to the PI and right to PI ==> sum of the values must be equal
        //
        // Sum of all the elements of the elements
        // 0th index cannot be can it? ==> edge case return -1
        //
        // tillIndexSum = 0
        // Loop through the elements index
        //
        // sum - tillIndexSum - index[PI] == tillIndexSum
        // then return index
        // else tillIndexSum = tillIndexSum + nums[index]
        // move forward ..
        // upon reaching PI == index.size - 1 return ==> -1

        if(nums == null){
            return -1;
        }

        if(nums.length == 1){
            return -1;
        }

        int totalSum = 0;
        for(int num: nums){
            totalSum = totalSum + num;
        }

        int tillIndexSum = 0;
        for(int index=0; index< nums.length; index++){
            if(tillIndexSum == (totalSum - tillIndexSum - nums[index])) {
//                index ==> PI
                return index;
            }

            tillIndexSum = tillIndexSum + nums[index];
        }

        return -1;
    }
}

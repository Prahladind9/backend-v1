package leetcode.learn.DataStructures.Array101;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3238/
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        System.out.println(
                maxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1})
                );
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        //Continuous/Consecutive Ones in the given array
        //1,1 --> 2
        //1,1,1 --> 3 ==> maxConsecutiveOnes are 3 with index range (3,5)

        int maxConsecutiveOnes = 0;
        int consecutiveOne = 0;
        for(int num: nums){
            if(num ==1){
                ++consecutiveOne;
                if(consecutiveOne > maxConsecutiveOnes)
                    maxConsecutiveOnes = consecutiveOne;
            }else{
                consecutiveOne=0;
            }
        }
        return maxConsecutiveOnes;
    }
}

package leetcode.Monthly.April.One;

public class MoveZeroes {

    public static void main(String[] args) {
        moveZeroesBF2(new int[]{0, 1, 0, 3, 12});
        moveZeroesBF2(new int[]{0, 0, 1, 0});
    }

    //Brute Force <  O(N~2)
    public static void moveZeroesBF2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int swapIndex = nonZeroIndex(i, nums);
                if (swapIndex == -1)
                    break;

                for (; swapIndex > i; swapIndex--) {
                    int temp = nums[swapIndex - 1];
                    nums[swapIndex - 1] = nums[swapIndex];
                    nums[swapIndex] = temp;
                }

            }
        }
        System.out.println(nums);
    }

    private static int nonZeroIndex(int givenIndex, int nums[]) {
        for (int k = givenIndex + 1; k < nums.length; k++) {
            if (nums[k] != 0) {
                return k;
            }
        }
        return -1;
    }


    //Brute Force  O(N~2)
    public static void moveZeroesBF(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int k = i; k < nums.length - 1; k++) {
                    int temp = nums[k];
                    nums[k] = nums[k + 1];
                    nums[k + 1] = temp;
                }
            }
        }
        System.out.println(nums);
    }

}



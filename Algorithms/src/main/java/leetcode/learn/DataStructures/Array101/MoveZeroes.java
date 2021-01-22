package leetcode.learn.DataStructures.Array101;

public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(new int[]{1, 0, 1});
        moveZeroes.moveZeroes(new int[]{2, 1});
        moveZeroes.moveZeroes(new int[]{1, 0});
        moveZeroes.moveZeroes(new int[]{0, 1, 0, 3, 12});
        moveZeroes.moveZeroes(new int[]{0, 0, 1, 0});
    }

    public void moveZeroes(int[] nums) {
        if (nums == null)
            return;
        if (nums.length == 1)
            return;

        int nonZeroIndex = 0;
        int zeroIndex = -1;
        int uniqueCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZeroIndex = i;
                if (uniqueCount != i && nonZeroIndex - zeroIndex >= 1) {
                    nums[zeroIndex] = nums[i];
                    ++zeroIndex;
                }
                uniqueCount++;
            } else {
                if (zeroIndex == -1) {
                    zeroIndex = i;
                }
            }
        }

        if (zeroIndex == 0 || uniqueCount == nums.length) {
            return;
        }

        for (int k = zeroIndex; k < nums.length; k++) {
            nums[k] = 0;
        }

        System.out.println(nums);
    }


}



package leetcode.learn.DataStructures.Array101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
        findDisappearedNumbers.findDisappearedNumbers(new int[]{5,4,6,7,9,3,10,9,5,6});
        findDisappearedNumbers.findDisappearedNumbers(new int[]{10,2,5,10,9,1,1,4,3,7});
        findDisappearedNumbers.findDisappearedNumbers(new int[]{1,2,3,3});
        findDisappearedNumbers.findDisappearedNumbers(new int[]{1,1});

        findDisappearedNumbers.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        findDisappearedNumbers.findDisappearedNumbers(new int[]{1,1,3});
        findDisappearedNumbers.findDisappearedNumbers(new int[]{1,1,4,5,1});
    }



    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedNumbers = new ArrayList<>();
        if(nums.length ==1){
            if(nums[0] ==1){
                return disappearedNumbers;
            }else{
                disappearedNumbers.add(1);
                return disappearedNumbers;
            }
        }

        Arrays.sort(nums);
        for (int i = 0, k = 1, lastFoundIndex = -1; i < nums.length; i++) {
            if (k == nums[i]) {
                if (i == k - 1) {
                    lastFoundIndex = i;
                    k++;
                } else {
                    lastFoundIndex  = i;
                    i = lastFoundIndex;
                    k++;
                }
            }

            if(i == nums.length -1 && k <= nums.length){
                disappearedNumbers.add(k);
                if(k==2) {
                   int l = 0;
                }
                i = lastFoundIndex;
                k++;
            }
        }

        return disappearedNumbers;
    }


//    Time Limit
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> disappearedNumbers = new ArrayList<>();
        if (nums.length == 1) {
            if (nums[0] == 1) {
                return disappearedNumbers;
            } else {
                disappearedNumbers.add(1);
                return disappearedNumbers;
            }
        }

        Arrays.sort(nums);
        for (int i = 0, k = 1; i < nums.length; i++) {

            if (k == nums[i]) {
                if (i == k - 1) {
                    k++;
                } else {
                    i = k - 1;
                    k++;
                }
            }

            if (i == nums.length - 1 && k <= nums.length) {
                disappearedNumbers.add(k);
                i = -1;
                k++;
            }
        }

        return disappearedNumbers;
    }

}

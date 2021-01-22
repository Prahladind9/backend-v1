package leetcode.learn.DataStructures.Array101;


import leetcode.learn.DataStructures.Shared.Helper;

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.mergeSortedArray(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        mergeSortedArray.mergeSortedArray(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
        mergeSortedArray.mergeSortedArray(new int[]{2, 0}, 1, new int[]{1}, 1);
        /*
        nums1 = [1,2,3,0,0,0], m = 3
        nums2 = [2,5,6],       n = 3
         */
    }

    private void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        //Check the 2 days till the mIndex and nIndex
        //If value of nums1 array is greater than the position of the nums2 array
        // then move the elements to next value and replace the value of narray

        int nCounter = 0;
        for (int i = 0; i < m; i++) {
            if (nCounter < n && nums1[i] >= nums2[nCounter]) {
                for (int k = m; k > i; k--) {
                    nums1[k] = nums1[k - 1];
                }
                nums1[i] = nums2[nCounter];
                ++nCounter;
                ++m;
            }
        }

        // remaining elements are moved here
        for (; m < nums1.length; m++, nCounter++) {
            nums1[m] = nums2[nCounter];
        }

        Helper.printIntArray(nums1);
    }
}

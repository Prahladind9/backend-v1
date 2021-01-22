package leetcode.learn.DataStructures.Array101;

import DataStructures.Shared.Helper;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
 */
public class DuplicateZeros {
    public static void main(String[] args) {
        DuplicateZeros duplicateZeros = new DuplicateZeros();
        duplicateZeros.duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
    }

    private void duplicateZeros(int[] arr) {
        //upon reaching 0 value in the array
        //1) move the values next i.e., from  i+ 2
        //2) we'll start from end - ones' own choice
        //3) set the i+1 value as 0 and increment the i index value as well
        if (arr.length == 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int k = arr.length - 1; k > i + 1; k--) {
                    arr[k] = arr[k - 1];
                }
                arr[i + 1] = 0;
                ++i;
            }
        }

        Helper.printIntArray(arr);
    }


    /*
// Say we want to insert the element at index 2.
// First, we will have to create space for the new element.
        for (int i = 4; i >= 2; i--)
        {
            // Shift each element one position to the right.
            intArray[i + 1] = intArray[i];
        }

// Now that we have created space for the new element,
// we can insert it at the required index.
        intArray[2] = 30;


     */
}
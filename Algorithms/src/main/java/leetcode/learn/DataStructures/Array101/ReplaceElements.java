package leetcode.learn.DataStructures.Array101;

import leetcode.learn.DataStructures.Shared.Helper;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/
 */
public class ReplaceElements {

    public static void main(String[] args) {
        ReplaceElements replaceElements = new ReplaceElements();
        Helper.printIntArray(replaceElements.replaceElements(new int[]{17,18,5,4,6,1}));
    }

    public int[] replaceElements(int[] arr) {
        if(arr.length ==1){
            arr[1] = -1;
            return arr;
        }
        int max;
        for(int i = 0; i < arr.length; i++){
            max = Integer.MIN_VALUE;
            for(int k = i +1; k < arr.length; k++){
                if(arr[k] > max)
                    max = arr[k];
            }

            if(i == arr.length -1) {
                arr[i] = -1;
            }else{
                arr[i] = max;
            }
        }

        return arr;
    }
}

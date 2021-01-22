package leetcode.learn.DataStructures.Array101;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3240/
 */
public class SquaresOfSortedArray {

    /*
    Complexity Analysis
    Time Complexity: O(NlogN), where N is the length of A.
    Space Complexity: O(N).
     */

    public static void main(String[] args) {
        SquaresOfSortedArray squaresOfSortedArray = new SquaresOfSortedArray();

        squaresOfSortedArray.printArray(squaresOfSortedArray.sortedSquares(new int[]{-7,-3,2,3,11}));
    }

    private int[] sortedSquares(int[] array){
        //We'll multiply each value and set in the same place
        // later sort the array
        for(int i =0; i < array.length; i++){
            array[i] = array[i] * array[i];
        }
        Arrays.sort(array);

        return array;
    }


    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

}

package leetcode.learn.DataStructures.Array101;

import java.util.Arrays;

public class HeightChecker {

    public static void main(String[] args) {
        HeightChecker heightChecker = new HeightChecker();
        heightChecker.heightChecker(new int[]{1,1,4,2,1,3});
        heightChecker.heightChecker(new int[]{5,1,2,3,4});
        heightChecker.heightChecker(new int[]{1,2,3,4,5});
        heightChecker.heightChecker(new int[]{2,2,1,1,1});
    }


    public int heightChecker(int[] heights) {
        if(heights.length ==1){
            return 0;
        }
        int[] heightsCopy = heights.clone();
        Arrays.sort(heightsCopy);
        int counter = 0;

        for(int i= 0; i< heights.length; i++){
            if(heights[i] !=heightsCopy[i]){
                ++counter;
            }
        }

        return counter;
    }
}

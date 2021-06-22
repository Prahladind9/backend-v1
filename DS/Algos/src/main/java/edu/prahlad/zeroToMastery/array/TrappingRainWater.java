package edu.prahlad.zeroToMastery.array;

/**
 * Given an array of integers representing an elevation map,
 * where the width of each bar is 1, return how much
 * rainwater can be trapped
 *
 * LeetCode
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    /**
     *
     * 0) Visualize the question
     *
     * 1) Verify the constraints
     *     a) Do the left & right sides of the graph count as walls?
     *          No, the sides are not walls.
     *     b) Will there be negative integers?
     *          No, assume all integers are +ve
     *
     * 2) Write out some test cases
     *    a) [0,1,0,2,1,0,3,1,0,1,2] > 8
     *    b) []  > 0
     *    c) [3] > 0
     *    d) [3,4,3] > 0
     *
     * 3) Figure out a solution without code (Critical Thinking)
     *    Figuring out 2 walls for the given index
     *    & their respective max value
     *
     *    Current Water capacity =
     *              min(max(leftElement) fromCurrent , max(rightElement) fromCurrent
     *                 ) - currentElementHeight
     *
     *   total = forAllElementsInArray ->find(CurrentWaterCapacity)
     *
     * 4) Write out our solution in code
     * 5) Double check for errors, syntax or logic
     * 6) Test our code with our test cases
     * 7) Analysis
     *   Technique: BruteForce
     *   TimeComplexity : O(n^2)
     *   SpaceComplexity: O(1)
     *
     * 8) Can we optimize our solution?
     *
     *
     *      a) identify pointer with lesser value
     *      b) is this pointer value <= max on that side
     *          yes -> update max on that side
     *          no  -> get water for pointer value, add to total
     *      c) move pointer inwards
     *      d) repeat for other pointer
     *
     *   Technique: 2 Pointer
     *   TimeComplexity : O(n)
     *   SpaceComplexity: O(1)
     */

    public static int getTrappedRainWater(int[] height){
        if (height == null || height.length <= 1) return 0;

        //totalWater, Left, Right - pointers & respective max value
        int     leftP = 0, rightP = height.length-1,
                maxLeft = 0, maxRight = 0, totalWater = 0;

        while (leftP < rightP){
            if(height[leftP] <= height[rightP]){
                if(height[leftP] >= maxLeft){
                    maxLeft = height[leftP];
                }else{
                    totalWater += maxLeft - height[leftP];
                }
                leftP++;
            }else{
                if(height[rightP] >= maxRight){
                    maxRight = height[rightP];
                }else{
                    totalWater += maxRight - height[rightP];
                }
                rightP--;
            }

        }

        return totalWater;
    }


    public static int getTrappedRainWaterBruteForce(int[] height){
        if (height == null || height.length <= 1) return 0;
        int totalWater = 0;
        for (int p = 0; p < height.length; p++) {

            //Left, Right - pointers & respective max value
            int leftP = p, rightP = p, maxLeft = 0, maxRight = 0;

            //Check all the left values
            while(leftP >= 0){
                maxLeft = Math.max(maxLeft, height[leftP]);
                leftP--;
            }

            //Check all the right values
            while (rightP < height.length){
                maxRight = Math.max(maxRight, height[rightP]);
                rightP++;
            }

            //Logic to get
            int currentWater = Math.min(maxLeft, maxRight) - height[p];
            if(currentWater >=0)
                totalWater += currentWater;
        }

        return totalWater;
    }

    public static void main(String[] args) {
        System.out.println(getTrappedRainWater(null));
        System.out.println(getTrappedRainWater(new int[]{}));
        System.out.println(getTrappedRainWater(new int[]{3}));
        System.out.println(getTrappedRainWater(new int[]{3,4,3}));
        System.out.println(getTrappedRainWater(new int[]{0,1,0,2,1,0,3,1,0,1,2}));
        System.out.println(getTrappedRainWater(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }




}

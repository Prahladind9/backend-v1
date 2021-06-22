package edu.prahlad.zeroToMastery.array;

/**
 * You are given an array of positive integers where each integer
 * represents the height of a vertical line on a chart.
 * Find two lines which together with the x-axis forms a container
 * that would hold the greatest amount of water.
 * Return the area of water it would hold.
 *
 * LeetCode
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    /**
     * 0) Visualize the question
     *      Graph & plot the array > Area = L * W,
     *        where L - minimum height of 2 integer values
     *            & W - distance between 2 points
     *
     * 1) Verify Constraints
     *    a) Does the thickness of the lines affect the area?
     *          No, assume they take up the space.
     *    b) Do the left & right sides of the graph count as walls?
     *          No, the sides cannot be used to form a container.
     *    c) Does a higher line inside our container affect our area?
     *          No, lines inside a container don't affect the area.
     *
     *  2) Write out some test cases
     *     a) [7,1,2,3,9] > 7 * 9 form the container
     *          Area = min(7,9) * distIndex(7,9)
     *               = 7 * distanceIndex(4-0)
     *               = 7 * 4 = 28
     *
     *     b) []  > Area = 0
     *     c) [7] > Area = 0
     *     d) [6,9,3,4,5,8]
     *          i)   recursively check all the pair combinations
     *          ii)  9 & 8 combinations returns the "greatest area"
     *          iii) Area = min(9,8) * distIndex(9,8)
     *                     = 8 * 4 = 32
     *
     *  3) Figure out a solution without code
     *      a) GeneralizeLogic: Area = min(a,b) * (index(b) - index(a))
     *          where a, b pointers
     *      b) variable maxArea = 0, to store the maxArea for the above calculations
     *      c) run the GeneralizeLogic for all the combinations
     *          & update the maxArea accordingly
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
     * 1st Loop > No Logic
     * 2nd Loop > building area & comparing
     *      Calculating height/length is the trick         (min)
     *                  width is constant decrement always (-1)
     *
     * Technique: "2 pointers" approach
     *
     * Analysis
     * TimeComplexity   : O(n)
     * SpaceComplexity  : O(1)
     */
    public static int getMaxWaterContainer(int[] height) {
        //EdgeCases
        if (height == null || height.length == 1) return 0;
        int maxArea = 0;
        int p1 = 0, p2 = height.length - 1;
        while (p1 < p2) {
            int length = Math.min(height[p1], height[p2]);
            int width = Math.abs(p2 - p1);
            int area = length * width;
            maxArea = Math.max(area, maxArea);
            if(height[p1] <= height[p2]){
                p1++;
            }else{
                p2--;
            }
        }
        return maxArea;
    }

    public static int getMaxWaterContainerBruteForce(int[] height) {
        //EdgeCases
        if (height == null || height.length == 1) return 0;
        int maxArea = 0;

        for (int a = 0; a < height.length; a++) {
//            System.out.println("a: "  +a + ", value: " + height[a]);
            for (int b = a + 1; b < height.length; b++) {
//                System.out.println("b: "  +b + ", value: " + height[b]);
                int length = Math.min(height[a], height[b]);
                int width = Math.abs(b - a);
                int area = length * width;
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(getMaxWaterContainer(null));
        System.out.println(getMaxWaterContainer(new int[]{}));
        System.out.println(getMaxWaterContainer(new int[]{1}));
        System.out.println(getMaxWaterContainer(new int[]{7,1,2,3,9}));
        System.out.println(getMaxWaterContainer(new int[]{6,9,3,4,5,8}));
        System.out.println(getMaxWaterContainer(new int[]{4,8,1,2,3,9}));
    }

}


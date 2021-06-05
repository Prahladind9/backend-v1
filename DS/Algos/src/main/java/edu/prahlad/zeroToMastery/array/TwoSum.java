package edu.prahlad.zeroToMastery.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers, return the indices of the two numbers
 * that add up to a given target.
 */
public class TwoSum {
    /**
     * 1) Verify the constraints
     * Q: Are all hte numbers +ve or can there be -ve's?
     * A: All numbers are +ve
     * [1,3,7,9,2]
     * <p>
     * Q: Are there duplicate numbers in the nums?
     * A: No, there are no duplicates or yes ...
     * [1,3,7,9,2]
     * <p>
     * Q: Will there always be a solution available?
     * A: No, there may not always be a solution.
     * <p>
     * Q: Can there be multiple pairs that add up to the target?
     * A: No, only 1 pair of numbers will add up to the target.
     * <p>
     * Q: What do we return if there's no solution?
     * A: Just return null
     * <p>
     * 2) Write out some test cases
     * 0 1 2 3 4
     * [1,3,7,9,2]  t = 11 return (3,4)
     * [1,2,3,4,5]  t = 25 return null
     * []           t = 3  return null
     * [5]          t = 8  return null
     * [5]          t = 5  return null
     * [1,6]        t = 7  return (0,1)
     * <p>
     * 3) Figure out a solution without code
     * 0 1 2 3 4
     * [1,3,7,9,2]  t=11
     * Pointer p1, p2
     * <p>
     * numberToFind = Target - nums[p1];
     * <p>
     * 4) Write out our solution in code
     * <p>
     * 5) Double check for errors
     * <p>
     * 6) Test our code with our test cases
     * <p>
     * 7) Analysis
     * Technique: Brute Force
     * TimeComplexity   : O(n^2)
     * SpaceComplexity  : O(1)
     * <p>
     * 8) Optimize Solution
     *
     *  1st Loop > calculate numberToFind(nft)
     *  2nd Loop > checks current == ntf > can this be improved?
     *          > using map retrieval - O(1)
     *
     * Analysis
     * TimeComplexity   : O(n)
     * SpaceComplexity  : O(n)
     */
    public static List<Integer> findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int p1 = 0; p1 < nums.length; p1++) {
            int numberToFind = target - nums[p1];
            if (map.containsKey(numberToFind) && map.get(numberToFind) != p1)
                return Arrays.asList(p1, map.get(numberToFind));

        }

        return null;
    }


    public static List<Integer> findTwoSumBruteForce(int[] nums, int target) {
        //if (nums == null || target < 0) throw new IllegalArgumentException();
        //Pointers - indexes
        for (int p1 = 0; p1 < nums.length; p1++) {
            int numberToFind = target - nums[p1];
            for (int p2 = p1 + 1; p2 < nums.length; p2++) {
                if (numberToFind == nums[p2]) return Arrays.asList(p1, p2);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(findTwoSum(new int[]{1, 3, 5, 7, 9, 2}, 11));
        System.out.println(findTwoSum(new int[]{1, 3, 5, 7, 9, 2}, 14));
        System.out.println(findTwoSum(new int[]{}, 14));
        System.out.println(findTwoSum(new int[]{1, 6}, 7));
        //System.out.println(twoSum(null, 7));
    }
}

package edu.prahlad.udemy3;

/**
 * You can climb 1 or 2 stairs with one step.
 * How many different ways can you climb n stairs?
 */
public class StairClimbing {
    /**
     * TimeComplexity: Exponential, ex: n =100 takes 30mins!!!
     *
     * @param n no of steps
     * @return no of ways to climb the steps
     */
    private final int stairsV0(int n) {
        //baseCase
        if (n == 1) return 1;
        if (n == 2) return 2;

        return stairsV0(n - 1) + stairsV0(n - 2);
    }

    //TimeComplexity: O(n)
    public long stairs(int n) {
        //baseCase
        if (n == 1) return 1;

        long[] ways = new long[n+1];
        ways[1] = 1;
        ways[2] = 2;

        for (int i = 3; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[n];
    }

}

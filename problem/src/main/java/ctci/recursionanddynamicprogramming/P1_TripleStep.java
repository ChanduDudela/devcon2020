package ctci.recursionanddynamicprogramming;

import java.util.Arrays;

public class P1_TripleStep {
    //brute-force
    int countWays(int stairs) {
        if (stairs < 0) {
            return 0;
        } else if (stairs == 0) {
            return 1;
        }

        return countWays(stairs - 1) + countWays(stairs - 2) + countWays(stairs - 3);
    }

    // using memoization (top-down approach)
    int countWaysMemoization(int stairs) {
        int[] memo = new int[stairs + 1];
        Arrays.fill(memo, -1);

        return countWaysMemoization(stairs, memo);
    }

    int countWaysMemoization(int stairs, int[] memo) {
        if (stairs < 0) {
            return 0;
        } else if (stairs == 0) {
            return 1;
        } else if (memo[stairs] > -1) {
            return memo[stairs];
        }

        memo[stairs] =
            countWaysMemoization(stairs - 1, memo) + countWaysMemoization(stairs - 2, memo)
                + countWaysMemoization(stairs - 3, memo);

        return memo[stairs];
    }
}

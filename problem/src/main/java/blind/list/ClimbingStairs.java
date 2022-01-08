package blind.list;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        // for a step, we could reach there from prev step or the step before that.
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}

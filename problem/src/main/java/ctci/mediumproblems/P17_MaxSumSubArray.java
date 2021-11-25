package ctci.mediumproblems;

public class P17_MaxSumSubArray {

    //DP approach
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int max = nums[0];

        int[] dp = new int[size];
        dp[0] = nums[0];

        for(int i =1; i< size; i++){
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1]: 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}

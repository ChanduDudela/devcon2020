package ctci.mediumproblems;

public class MaxSubArray {

    int getMaxSubArray(int[] arr) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (maxSum < sum) {
                maxSum = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    // another approach
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

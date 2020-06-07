package aws.onlineassesment;

import java.util.Arrays;

//https://leetcode.com/problems/two-sum/
//https://leetcode.com/discuss/interview-question/356960
public class TwoSum {

    //brute force - quadratic time O(n^2)
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i< nums.length; i++){
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    //with O(n log n) time
    public int[] twoSum_NLogN_time(int[] nums, int target) {
        target= target-30;

        int[] result = new int[2];
        int[] copyOfNums = Arrays.copyOf(nums, nums.length);

        //quick sort O(n log(n))
        Arrays.sort(copyOfNums);

        int i =0;
        int a = 0, b = 0;
        int j = nums.length-1;

        while (i < j) {
            if (copyOfNums[i] + copyOfNums[j] > target) {
                j--;
            } else if (copyOfNums[i] + copyOfNums[j] < target) {
                i++;
            } else {
                a = copyOfNums[i];
                b = copyOfNums[j];
                break;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if(nums[k] == a){
                result[0] = k;
                break;
            }
        }
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == b) {
                result[1] = k;
                break;
            }
        }

       return result;
    }
}

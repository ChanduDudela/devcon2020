package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 2) {
            return result;
        }

        // to group all same numbers togethers
        Arrays.sort(nums);

        for(int i=0; i < nums.length - 1 ; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int curr = i; // curr + (2 sum should be equal to -curr to that 3sum = 0)
                int begin = i+1; // search from next element
                int end = nums.length-1; // until the end
                int targetSum = -nums[curr];

                while (begin < end) {
                    if (nums[begin] + nums[end] == targetSum) {
                        result.add(Arrays.asList(nums[curr], nums[begin], nums[end]));

                        while (begin < end && nums[begin] == nums[begin+1]) {
                            begin++;
                        }
                        while (begin < end && nums[end] == nums[end-1]) {
                            end--;
                        }
                        begin++;
                        end--;
                    } else if (nums[begin] + nums[end] < targetSum) {
                        while (begin < end && nums[begin] == nums[begin+1]) {
                            begin++;
                        }
                        begin++;
                    } else {
                        while (begin < end && nums[end] == nums[end-1]) {
                            end--;
                        }
                        end--;
                    }
                }
            }
        }

        return result;
    }
}

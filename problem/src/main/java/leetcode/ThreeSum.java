package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int begin = i + 1;
                int end = nums.length - 1;
                int sum = -nums[i];

                while (begin < end) {
                    if (nums[begin] + nums[end] == sum) {
                        result.add(Arrays.asList(nums[i], nums[begin], nums[end]));

                        while (begin < end && nums[begin] == nums[begin++]) {
                            begin++;
                        }
                        while (begin < end && nums[end - 1] == nums[end]) {
                            end--;
                        }
                        begin++;
                        end--;
                    } else if (nums[begin] + nums[end] < sum) {
                        while (begin < end && nums[begin] == nums[begin++]) {
                            begin++;
                        }
                        begin++;
                    } else {
                        while (begin < end && nums[end - 1] == nums[end]) {
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

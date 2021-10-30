package leetcode;

public class SetMismatch {
    //Explanation - https://www.youtube.com/watch?v=u6Dt9av66yM&t=65s
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;

            if (nums[index] < 0) {
                res[0] = index+1;
            } else {
                nums[index] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[1] = i+1;
            }
        }

        return res;
    }
}

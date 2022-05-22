package blind.list;

public class ProductOfArrayExceptItself {
    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];

        // product of lefts
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                left = left * nums[i];
            }
            res[i] = left;
        }

        // product of rights
        int right = 1;
        for (int i = nums.length-1; i > 0 ; i--) {
            if (i < nums.length-1){
                right = right * nums[i+1];
            }

            res[i] = res[i] * right;
        }

        return res;
    }
}

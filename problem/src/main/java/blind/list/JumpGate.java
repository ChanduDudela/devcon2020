package blind.list;

public class JumpGate {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i <= farthest && i < nums.length; i++) {
            farthest = Math.max(farthest, i + nums[i]);
        }
        return farthest >= nums.length;
    }
}

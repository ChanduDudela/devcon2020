package aws.random.questions;

//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {

    public int trap(int[] height) {

        if(height == null || height.length <= 1){
            return 0;
        }

        int size = height.length;

        //calculate left max heights for an index
        int[] leftMaxs = new int[size];
        leftMaxs[0] = height[0];
        for(int i =1; i < size; i++){
            leftMaxs[i] = Math.max(leftMaxs[i-1], height[i]);
        }

        //calculate right max heights for an index
        int[] rightMaxs = new int[size];
        rightMaxs[size-1] = height[size-1];
        for(int i =size-2; i >=0; i--){
            rightMaxs[i] = Math.max(height[i], rightMaxs[i+1]);
        }

        // Calculate amount of water that can be stored above each spot on histogram
        int waterLevel = 0;

        for(int i =1; i < size; i++){
            waterLevel += Math.min(leftMaxs[i], rightMaxs[i]) - height[i];
        }

        return waterLevel;
    }
}

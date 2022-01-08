package blind.list;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxArea = 0;

        while (start < end) {
            int length = end - start;
            int breadth = Math.min(height[start], height[end]);
            maxArea = Math.max(maxArea, length * breadth);

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }
}

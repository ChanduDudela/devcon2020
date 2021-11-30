package aws.onlineassesment;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/k-closest-points-to-origin/
public class TopKClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> getDistance(b) - getDistance(a));

        for (int[] point: points) {
            maxHeap.offer(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int size = maxHeap.size();
        int[][] res = new int[size][2];

        for (int i =0; i < size; i++) {
            res[i] = maxHeap.poll();
        }

        return res;
    }

    private int getDistance (int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}

package aws.onlineassesment;

import java.util.PriorityQueue;
import java.util.Queue;

public class TopKClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> pq = new PriorityQueue<>(
            (p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));

        for (int[] point : points) {
            pq.offer(point);

            if (pq.size() > K) {
                pq.poll();
            }
        }

        int[][] result = new int[K][2];

        while (!pq.isEmpty() && K > 0) {
            result[K - 1] = pq.poll();
            K--;
        }

        return result;
    }
}

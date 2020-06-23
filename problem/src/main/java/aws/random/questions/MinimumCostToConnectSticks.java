package aws.random.questions;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostToConnectSticks {

    public static void main(String[] args) {
        int[] sticks = {2};
        System.out.println(connectSticks(sticks));
    }

    public static int connectSticks(int[] sticks) {
        if(sticks.length == 1){
            return 0;
        }

        Queue<Integer> minHeap = new PriorityQueue<>();
        int cost = 0;
        int tempCount;

        for (int stick : sticks) {
            minHeap.add(stick);
        }

        while(minHeap.size() > 1){
            tempCount = minHeap.poll() + minHeap.poll();
            cost+= tempCount;
            minHeap.add(tempCount);
        }

        return cost;
    }
}

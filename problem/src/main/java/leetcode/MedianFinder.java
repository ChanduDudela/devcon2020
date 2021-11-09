package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

// Two Heaps Approach
// https://leetcode.com/problems/find-median-from-data-stream/solution/
public class MedianFinder {

    /** initialize your data structure here. */
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() == 0){
            return 0.0;
        }

        if(minHeap.size() == maxHeap.size()){
            return (double) (minHeap.peek() + maxHeap.peek())/ 2 ;
        } else {
            return (double) maxHeap.peek();
        }
    }
}

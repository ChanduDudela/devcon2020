package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {

    /* Brute force using max heap for each sliding window*/
    public int[] maxSlidingWindow_BruteForce(int[] nums, int k) {

        if (nums.length * k == 0) {
            return nums;
        }

        int[] results = new int[nums.length - k + 1];

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < nums.length - k + 1; i++) {

            for (int j = i; j < i + k; j++) {
                maxHeap.offer(nums[j]);
            }

            results[i] = maxHeap.poll();
            maxHeap.clear();
        }

        return results;
    }


    /* Using Deque - O(N) linear solution
    *  Explanation - https://www.youtube.com/watch?v=DfljaUwZsOk
    * */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return new int[] {0};
        }

        int[] res = new int[nums.length - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;

        while (i < nums.length) {
            //check if elements are out of bounds of current window and remove them
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            //check if last element in the que is less than current value and remove it
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // from the range where i is able to create a window
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }

            i++;
        }

        return res;
    }
}

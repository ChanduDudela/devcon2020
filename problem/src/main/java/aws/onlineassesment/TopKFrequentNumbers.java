package aws.onlineassesment;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 */
//https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentNumbers {
    public static void main(String[] args) {
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberCountMap = new HashMap<>();

        if (nums.length == 0) {
            return new int[0];
        }

        for (int number : nums) {
            numberCountMap.put(number, numberCountMap.getOrDefault(number, 0) + 1);
        }

        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(numberCountMap::get));

        for(Integer key : numberCountMap.keySet()){
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];

        int i = 0;
        while (!minHeap.isEmpty() && k-- > 0) {
            result[i++] = minHeap.poll();
        }
        return result;
    }
}

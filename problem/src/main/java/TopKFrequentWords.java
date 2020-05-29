import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequentWords {
    public static void main(String[] args) {
    }

    public List<String> topKFrequent(String[] reviews, int k) {

        List<String> result = new ArrayList<>();
        Map<String,Integer> keywordCountMap = new HashMap<>();

        if (reviews.length == 0) {
            return result;
        }

        for (String review : reviews) {
            if (keywordCountMap.containsKey(review)) {
                keywordCountMap.put(review, keywordCountMap.get(review) + 1);
            } else {
                keywordCountMap.put(review, 1);
            }
        }

        Queue<Map.Entry<String, Integer>> maxHeap =
            new PriorityQueue<>(
                (a, b)-> a.getValue().equals(b.getValue())
                    ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

        maxHeap.addAll(keywordCountMap.entrySet());

        while (!maxHeap.isEmpty() && k-- > 0) {
            result.add(maxHeap.poll().getKey());
        }
        return result;
    }
}

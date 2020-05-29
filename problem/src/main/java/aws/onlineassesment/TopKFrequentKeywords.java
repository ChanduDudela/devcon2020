package aws.onlineassesment;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/discuss/interview-question/542597/
public class TopKFrequentKeywords {
    public static void main(String[] args) {
    }

    public static String[] findTopKFrequentlyMentionedWords(int k, String[] keywords, String[] reviews) {
        String [] result = new String[k];
        Map<String,Integer> keywordCountMap = new HashMap<>();

        if (keywords.length == 0 || reviews.length == 0) {
            return result;
        }

        for (String keyword : keywords) {
            for (String review : reviews) {
                if (review.contains(keyword)){
                    Integer count = keywordCountMap.getOrDefault(keyword, 0);
                    keywordCountMap.put(keyword, count + 1);
                }
            }
        }

        Queue<Map.Entry<String, Integer>> maxHeap =
            new PriorityQueue<>(
                (a, b)-> a.getValue().equals(b.getValue())
                    ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

        maxHeap.addAll(keywordCountMap.entrySet());

        int j =0;
        while (!maxHeap.isEmpty() && k-- > 0) {
            result[j++] = maxHeap.poll().getKey();
        }
        return result;
    }
}

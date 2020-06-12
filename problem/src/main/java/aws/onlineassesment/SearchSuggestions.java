package aws.onlineassesment;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/search-suggestions-system/
public class SearchSuggestions {
    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};

        System.out.println(suggestedProducts(products, "mouse").toString());
    }

    //Approach using PQ
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Queue<String> queue = new PriorityQueue<>(3);

        for (int i = 1; i <= searchWord.length(); i++) {

            for (String product : products) {
                if (product.startsWith(searchWord.substring(0, i))) {
                    queue.offer(product);
                }
            }
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (null != queue.peek()) {
                    temp.add(queue.poll());
                }
            }
            queue.clear();
            result.add(temp);
        }
        return result;
    }
}

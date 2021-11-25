package ctci.hardproblems;

import java.util.LinkedList;
import java.util.Queue;

public class P9_KthMultiple {

    int removeMinimumValue(Queue<Integer> queue) {
        int min = queue.peek();
        for (int i: queue) {
            if (min > i) {
                min = i;
            }
        }

        while(queue.contains(min)) {
            queue.remove(min);
        }

        return min;
    }

    void addMultiples(Queue<Integer> queue, int val) {
        queue.add(val * 3);
        queue.add(val * 5);
        queue.add(val * 7);
    }

    int getKthMultiple(int k) {
        int val = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(val);

        for (int i = 0; i < k; i++) {
            val = removeMinimumValue(queue);
            addMultiples(queue, val);
        }

        return val;
    }
}

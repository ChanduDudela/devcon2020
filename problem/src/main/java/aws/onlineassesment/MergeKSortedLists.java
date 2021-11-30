package aws.onlineassesment;

import static aws.onlineassesment.Merge2SortedLists.*;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode tempHead = new ListNode(0);
        ListNode tempTail = tempHead;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tempTail.next = node;
            tempTail = tempTail.next;

            if (node.next != null) {
                queue.add(node.next);
            }
        }

        return tempHead.next;
    }
}

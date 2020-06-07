package aws.onlineassesment;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/copy-list-with-random-pointer/
*/
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class DeepCloneRandomList {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node headRef = head;
        Map<Node, Node> cloneMap = new HashMap<>();

        //loop and put node with value as its cloned node
        while (head != null) {
            cloneMap.put(head, new Node(head.val));
            head = head.next;
        }

        for (Map.Entry<Node, Node> entry : cloneMap.entrySet()) {
            Node next = entry.getKey().next;
            entry.getValue().next = cloneMap.get(next);

            Node random = entry.getKey().random;
            entry.getValue().random = cloneMap.get(random);
        }

        return cloneMap.get(headRef);
    }
}

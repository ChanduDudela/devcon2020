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

public class DeepCloneListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node headRef = head;
        Node headRefCopy = head;

        Map<Node, Node> cloneMap = new HashMap<>();

        //loop and put node with value as its cloned node
        while (head != null) {
            cloneMap.put(head, new Node(head.val));
            head = head.next;
        }

        while (headRef != null) {
            Node clone = cloneMap.get(headRef);
            clone.next = cloneMap.get(headRef.next);
            clone.random = cloneMap.get(headRef.random);

            headRef = headRef.next;
        }

        return cloneMap.get(headRefCopy);
    }
}

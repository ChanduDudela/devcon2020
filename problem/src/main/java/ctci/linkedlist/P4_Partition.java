package ctci.linkedlist;

import ctci.linkedlist.P2_KthFromLast.Node;

public class P4_Partition {

    // My own solution. Refer CTCI 2nd solution
    public static Node removeNode(Node head, int x) {
        Node small = new Node(-1);
        Node smallRef = small;

        Node big = new Node(-1);
        Node bigRef = big;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }

        small.next = bigRef.next;

        return smallRef.next;
    }
}

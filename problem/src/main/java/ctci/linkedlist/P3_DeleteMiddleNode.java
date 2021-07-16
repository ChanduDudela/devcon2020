package ctci.linkedlist;

import ctci.linkedlist.P2_KthFromLast.Node;

public class P3_DeleteMiddleNode {
    public static boolean removeNode(Node a) {
        if (a == null || a.next == null) {
            return false;
        }

        Node next = a.next;
        a.val = next.val;
        a.next = next.next;
        return true;
    }
}

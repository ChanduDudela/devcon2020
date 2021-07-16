package ctci.linkedlist;

import ctci.linkedlist.P2_KthFromLast.Node;

public class P5_SumLists {

    public static Node addLists(Node l1, Node l2) {
        return addLists(l1, l2, 0);
    }

    static Node addLists(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        Node result = new Node();
        int total = carry;

        if (l1 != null) {
            total = total + l1.val;
        }

        if (l2 != null) {
            total = total + l2.val;
        }

        result.val = total % 10; // remainder

        // recurse
        if (l1 != null || l2 != null) {
            Node nextNodeResult =
                addLists(l1.next == null ? null : l1.next, l2.next == null ? null : l2.next,
                    total >= 10 ? 1 : 0);
            result.next = nextNodeResult;
        }

        return result;
    }
}

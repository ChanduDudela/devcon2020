package ctci.linkedlist;

import ctci.linkedlist.P2_KthFromLast.Node;

public class P7_Intersection {

    // check tails are same, if not return false
    // while doing so, calculate the length of each list
    // to make lists of equal size, remove (bigger list size - small list size) extra nodes from bigger list.
    // iterate from start for both lists and then return when same reference is found.
    public static Node getIntersectingNode(Node l1, Node l2) {
        // k -> a -> t -> a -> k
        // p -> q ->/

        // k -> a -> t -> a -> k
        // p -> q -> t -> a -> k

        if (l1 == null || l2 == null) {
            return null;
        }

        Result r1 = getTailAndSize(l1);
        Result r2 = getTailAndSize(l2);

        if (r1.tail != r2.tail) {
            return null;
        }

        int diff;
        if (r1.size > r2.size) {
            diff = r1.size - r2.size;
            l1 = chopOff(l1, diff);
        } else if (r1.size < r2.size) {
            diff = r2.size - r1.size;
            l2 = chopOff(l2, diff);
        }

        while (l1 != null && l2 != null){
            if (l1 == l2) {
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return null;
    }


    static Node chopOff(Node l, int diff) {
        while (diff > 0 && l != null) {
            l = l.next;
            diff--;
        }
        return l;
    }

    static Result getTailAndSize(Node l) {
        int count = 0;
        while (l != null && l.next != null) {
            count++;
            l = l.next;
        }
        return new Result(l.next, count);
    }

    static class Result {
        public Result(Node tail, int size) {
            this.tail = tail;
            this.size = size;
        }

        Node tail;
        int size;
    }
}

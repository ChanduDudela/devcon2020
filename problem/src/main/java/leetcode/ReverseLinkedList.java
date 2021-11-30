package leetcode;

public class ReverseLinkedList {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node reverse(Node head) {
        Node curr = head;
        Node next;
        Node prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}

package ctci.linkedlist;

public class P2_KthFromLast {

    // O(N) time and constant space
    // take p2 to k places from start
    // then move both p1 and p2 until p2 is not null. Then p1 will end at total-Kth place
    // from beginning (kth place from end)
    public Node returnKthNodeFromEnd(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

        for(int i=0; i< k; i++){
            if(p2 == null) return null;
            p2 = p2.next;
        }

        while(p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        return p1;
    }

    static class Node {
        int val;
        Node next;

        Node() {
            new Node(0);
        }

        Node(int val) {
            this.val = val;
        }
    }
}

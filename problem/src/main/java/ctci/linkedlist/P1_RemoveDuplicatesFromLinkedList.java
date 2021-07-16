package ctci.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class P1_RemoveDuplicatesFromLinkedList {

    // O(N) time with buffer space
    public static void removeDuplicates(Node li) {
        Set<Integer> set = new HashSet<>();
        Node previous = null;

        while(li != null) {
            if(set.contains(li.val)) {
                previous.next = li.next;
            } else {
                set.add(li.val);
                previous = li;
            }
            li = li.next;
        }
    }

    // Using Runner technique. O(1) space but O(N^2) time
    public static void removeDuplicatesNoBuffer(Node li) {
        Node current = li;

        while(current != null) {
            Node runner = current;
            while (runner.next != null){
                if(runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}

package ctci.linkedlist;

import ctci.linkedlist.P2_KthFromLast.Node;
import java.util.Stack;

public class P6_Palindrome {

    // method-1 reverse the list and compare
    public static boolean isPalindrome(Node head) {
        // k -> a -> t -> t -> a -> k            = 3
        // k -> a -> t -> p -> t -> a -> k       = 4

        Node reversedHead = reverseAndClone(head);
        return compare(head, reversedHead);
    }

    static Node reverseAndClone(Node l1) {
        Node head = null;

        while (l1 != null) {
            Node clone = new Node(l1.val);
            clone.next = head;
            head = clone;

            l1 = l1.next;
        }

        return head;
    }

    static boolean compare(Node head, Node reversedHead) {

        while (head != null && reversedHead != null) {
            if(head.val != reversedHead.val) {
                return false;
            }
            head = head.next;
            reversedHead = reversedHead.next;
        }

        return head == null && reversedHead == null;
    }


    // method-2 Iterative approach using Stack
    public static boolean isPalindrome_usingStack(Node head) {
        // k -> a -> t -> t -> a -> k            = 3
        // k -> a -> t -> p -> t -> a -> k       = 4

        // for even, fast pointer ends at null and element at slow pointer is first element in second half
        // for odd, fast pointer ends at last element (non-null) and element at slow pointer should be removed.
        Node fast = head;
        Node slow = head;

        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.val);

            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if(stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}

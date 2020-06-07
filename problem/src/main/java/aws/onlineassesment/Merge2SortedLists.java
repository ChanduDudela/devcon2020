package aws.onlineassesment;

//https://leetcode.com/problems/merge-two-sorted-lists/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Merge2SortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode(-1);
        ListNode head = mergedList;

        while(l1.next != null && l2.next != null){
            if(l1.val <= l2.val){
                head.next = l1;
                l1 = l1.next;
            } else{
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        if(l1.next == null && l2.next == null){
            return mergedList;
        }
        else if(l1.next == null){
            head.next = l2;
        }
        else {
            head.next = l1;
        }

        return mergedList;
    }
}

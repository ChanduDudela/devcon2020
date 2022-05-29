package aws.onlineassesment;

public class Merge2SortedLists {

    public static void main(String[] args) {
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode(-1);

        ListNode prevNode = resultList;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prevNode.next = l1;
                l1 = l1.next;
            } else {
                prevNode.next = l2;
                l2 = l2.next;
            }
            prevNode = prevNode.next;
        }

        prevNode.next = l1 == null ? l2: l1;

        return resultList.next;
    }

    public static class ListNode {
        int val;
        public ListNode next;

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
}

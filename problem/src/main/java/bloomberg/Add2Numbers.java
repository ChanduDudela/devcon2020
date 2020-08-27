package bloomberg;

//https://leetcode.com/problems/add-two-numbers/
public class Add2Numbers {

	public ListNode addTwoNumbers_(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		int carry = 0;

		while(l1 != null || l2 != null){
			int x = l1 != null ? l1.val : 0;
			int y = l2 != null ? l2.val : 0;

			int sum = x + y + carry;

			carry = sum / 10;
			dummy.next = new ListNode(sum % 10);
			dummy = dummy.next;

			if(l1 != null){
				l1 = l1.next;
			}

			if(l2 != null){
				l2 = l2.next;
			}
		}
		if(carry > 0){
			dummy.next = new ListNode(carry);
		}

		return head.next;
	}

	public static class ListNode {
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
}

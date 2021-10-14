package leetcode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
public class BinaryTree_RightPointers {

	public Node connect(Node root) {
		if(root == null){
			return null;
		}

		Queue<Node> que = new LinkedList<>();
		que.add(root);

		while(!que.isEmpty()){
			int size = que.size();

			for(int i =0; i < size; i++){
				Node node = que.poll();

				if(i < size-1){
					node.next = que.peek();
				}

				if(node.left != null){
					que.add(node.left);
				}
				if(node.right != null){
					que.add(node.right);
				}
			}

		}
		return root;
	}

	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}
}

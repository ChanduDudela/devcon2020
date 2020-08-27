package bloomberg;

import aws.random.questions.BSTIterator.TreeNode;

//https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBST {
	public boolean isValidBST(TreeNode root) {

		return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean validate(TreeNode node, long min, long max){
		if(node == null){
			return true;
		}

		if(node.val <= min || node.val >= max){
			return false;
		}
		return validate(node.left, min, node.val) && validate(node.right, node.val, max);
	}
}

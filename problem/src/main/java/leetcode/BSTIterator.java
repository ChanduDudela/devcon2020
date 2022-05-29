package leetcode;

import java.util.Stack;

//https://leetcode.com/problems/binary-search-tree-iterator (IN-ORDER => left - root - right)
// there is another approach of flattening the tree into an array.
// See first approach in the solutions tab.
public class BSTIterator {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private final Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();

        traverseAllLeftNodes(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();

        //when this node has a right child,
        //then we add all left nodes of this node to the stack
        if (node.right != null) {
            traverseAllLeftNodes(node.right);
        }

        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }

    // helper to traverse all left nodes (minimum values in the tree in-order traversal)
    // and add it to the stack
    private void traverseAllLeftNodes(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}

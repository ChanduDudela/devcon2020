package aws.onlineassesment;

//https://leetcode.com/problems/subtree-of-another-tree/
public class SubTreeOfAnotherTree {

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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        return searchRootAndMatch(root, subRoot);
    }

    boolean searchRootAndMatch(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }

        if (t1.val == t2.val && isMatch(t1, t2)) {
            return true;
        }

        return searchRootAndMatch(t1.left, t2) || searchRootAndMatch(t1.right, t2);
    }

    boolean isMatch(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else if (t1.val != t2.val) {
            return false;
        }
        return isMatch(t1.left, t2.left) && isMatch(t1.right, t2.right);
    }

    // another approach
    public boolean isSubtree2(TreeNode s, TreeNode t) {
        StringBuilder sb = new StringBuilder();
        preOrder(s, sb);
        String sourcePreOrderString = sb.toString();

        sb = new StringBuilder();
        preOrder(t, sb);
        String targetPreOrderString = sb.toString();

        return sourcePreOrderString.contains(targetPreOrderString);
    }

    public void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null");
            return;
        }

        sb.append('#').append(node.val);

        preOrder(node.left, sb);

        preOrder(node.right, sb);
    }
}

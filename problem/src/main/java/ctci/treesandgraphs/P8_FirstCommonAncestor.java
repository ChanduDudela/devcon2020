package ctci.treesandgraphs;

public class P8_FirstCommonAncestor {

    TreeNode findFirstCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // validate if nodes are present in the tree
        if (!checkNodeInSubTree(root, p) && !checkNodeInSubTree(root, q)) {
            return null;
        }

        boolean pInLeft = checkNodeInSubTree(root.left, p);
        boolean qInLeft = checkNodeInSubTree(root.left, q);
        if (pInLeft && qInLeft) {
            root = root.left;
            return findFirstCommonAncestor(root, p, q);
        } else if(!pInLeft && !qInLeft) {
            root = root.right;
            return findFirstCommonAncestor(root, p, q);
        } else {
            return root;
        }
    }

    boolean checkNodeInSubTree(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }

        if (root == node) {
            return true;
        } else {
            return checkNodeInSubTree(root.left, node) || checkNodeInSubTree(root.right, node);
        }
    }
}

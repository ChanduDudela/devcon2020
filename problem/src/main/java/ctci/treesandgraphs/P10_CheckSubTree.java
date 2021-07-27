package ctci.treesandgraphs;

public class P10_CheckSubTree {
    boolean isSubtree(TreeNode t1, TreeNode t2) {
        StringBuilder sb1 = new StringBuilder();
        getPreOrder(t1, sb1);

        StringBuilder sb2 = new StringBuilder();
        getPreOrder(t2, sb2);

        return sb1.indexOf(sb2.toString()) != -1;
    }

    void getPreOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null");
            return;
        }

        sb.append("#").append(root.val);

        getPreOrder(root.left, sb);
        getPreOrder(root.right, sb);
    }

    // Alternate approach
    boolean isSubtree2(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        return isRootMatch(t1, t2);
    }

    boolean isRootMatch(TreeNode t1, TreeNode t2) {
        if (t1 == null){
            return false;
        }
        if (t1.val == t2.val && isMatch(t1, t2)) {
            return true;
        }
        return isRootMatch(t1.left, t2) || isRootMatch(t1.right, t2);
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
}

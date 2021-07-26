package ctci.treesandgraphs;

public class P2_MinimalTree {
    public Node createMinimalBST(int[] arr) {
        return createMinimalBST(arr, 0, arr.length-1);
    }

    private Node createMinimalBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) /2;
        Node root = new Node(arr[mid]);
        root.left = createMinimalBST(arr, start, mid-1);
        root.right = createMinimalBST(arr, mid+1, end);

        return root;
    }

    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}

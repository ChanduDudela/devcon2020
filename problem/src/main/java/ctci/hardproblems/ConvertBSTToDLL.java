package ctci.hardproblems;

public class ConvertBSTToDLL {
    static class BiNode {
        BiNode left;
        BiNode right;

        public BiNode(int data) {
            this.data = data;
        }

        int data;
    }

    static class NodePair {
        BiNode head;
        BiNode tail;

        public NodePair(BiNode head, BiNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    NodePair convertToDLL(BiNode root) {
        if (root == null) {
            return null;
        }

        NodePair pair1 = convertToDLL(root.left);
        NodePair pair2 = convertToDLL(root.right);

        if (pair1 != null) {
            combine(pair1.tail, root);
        }

        if (pair2 != null) {
            combine(root, pair2.head);
        }

        return new NodePair(pair1 == null ? root : pair1.head, pair2 == null ? root : pair2.tail);
    }

    void combine(BiNode x, BiNode y) {
        x.right = y;
        y.left = x;
    }

    public static void main(String[] args) {
        BiNode root = new BiNode(10);

        root.left = new BiNode(8);
        root.left.right = new BiNode(9);
        root.left.left = new BiNode(3);
        root.left.left.left = new BiNode(2);

        root.right = new BiNode(17);
        root.right.left = new BiNode(12);
        root.right.right = new BiNode(20);

        NodePair left = new ConvertBSTToDLL().convertToDLL(root);
        BiNode node = left.head;

        while (node != null) {
            System.out.println(node.data);
            node = node.right;
        }
    }
}

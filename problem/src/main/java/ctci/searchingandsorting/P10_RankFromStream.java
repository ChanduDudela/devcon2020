package ctci.searchingandsorting;

public class P10_RankFromStream {
    RankNode root = null;

    void track (int x) {
        if (root == null) {
            root = new RankNode(x);
        } else {
            root.insert(x);
        }
    }

    int getRankOfNumber(int x) {
        return root != null ? root.getRank(x) : -1;
    }

    static class RankNode {
        int leftSize  = 0;
        int val;
        RankNode right;
        RankNode left;

        public RankNode(int val) {
            this.val = val;
        }

        void insert(int x) {
            if (x > val) {
                if (right == null) {
                    right = new RankNode(x);
                } else {
                    right.insert(x);
                }
            } else {
                if (left == null) {
                    left = new RankNode(x);
                } else {
                    left.insert(x);
                }
                leftSize++;
            }
        }

        int getRank(int a) {
            if (a == val) {
                return leftSize;
            } else if (a < val) {
                if (left == null) {
                    return -1;
                } else {
                    return left.getRank(a);
                }
            } else {
                int rightRank = right == null ? -1 : right.getRank(a);

                if (rightRank == -1) {
                    return -1;
                } else {
                    return leftSize + 1 + rightRank;
                }
            }
        }
    }
}

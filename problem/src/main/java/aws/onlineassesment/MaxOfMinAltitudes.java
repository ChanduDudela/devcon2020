package aws.onlineassesment;

public class MaxOfMinAltitudes {

    public static void main(String[] args) {

        int[][] grid = {{1, 2, 3},
            {4, 5, 1}};

        int[][] grid2 = {{5, 1},
            {4, 5}};

        System.out.println(maximumPath(grid));
    }

    private static int maximumPath(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int[][] minValueMatrix = new int[r][c];

        //Assigning source index and target index MAX values, since they do not count
        minValueMatrix[0][0] = Integer.MAX_VALUE;
        minValueMatrix[r - 1][c - 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                minValueMatrix[i][j] = matrix[i][j];

                if (i > 0 && j > 0) {
                    minValueMatrix[i][j] = Math.max(
                        Math.min(minValueMatrix[i][j], minValueMatrix[i - 1][j]),
                        Math.min(minValueMatrix[i][j], minValueMatrix[i][j - 1]));
                } else if (i > 0) {
                    minValueMatrix[i][j] = Math.min(minValueMatrix[i][j], minValueMatrix[i - 1][j]);
                } else if (j > 0) {
                    minValueMatrix[i][j] = Math.min(minValueMatrix[i][j], minValueMatrix[i][j - 1]);
                }
            }
        }

        return minValueMatrix[r - 1][c - 1];
    }
}

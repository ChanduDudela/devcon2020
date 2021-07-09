package ctci.arraysandstring;

import java.util.Arrays;

public class Problem8_ZeroMatrix {

    public static int[][] process(int[][] matrix) {
        //maintain 1 index for 1 entire row
        boolean[] rows = new boolean[matrix.length];
        //maintain 1 index for 1 entire col
        boolean[] cols = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (rows[i]) {
                //set row zero
                zerofyRow(matrix, i);
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (cols[j]) {
                //set col zero
                zerofyColumn(matrix, j);
            }
        }

        return matrix;
    }

    public static void zerofyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    public static void zerofyColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{0,1,2}, {3,0,4}, {5,2,1}};
        System.out.println(Arrays.deepToString(Problem8_ZeroMatrix.process(mat)));
    }
}

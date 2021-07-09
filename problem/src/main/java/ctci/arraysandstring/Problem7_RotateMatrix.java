package ctci.arraysandstring;

import java.util.Arrays;

public class Problem7_RotateMatrix {
    // Rotate by +90:
    //
    // Transpose
    // Reverse each column

    // Rotate by -90:
    //
    // Transpose
    // Reverse each row

    public static int[][] rotate(int[][] matrix) {
        transpose(matrix);
        reflectColumns(matrix);

        return matrix;
    }

    public static void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    //public static void reflectRows(int[][] matrix) {
    //    int n = matrix.length;
    //    for (int i = 0; i < n/2; i++) {
    //        for (int j = 0; j < n; j++) {
    //            int temp = matrix[i][j];
    //            matrix[i][j] = matrix[n-i-1][j];
    //            matrix[n-i-1][j] = temp;
    //        }
    //    }
    //}

    public static void reflectColumns(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = { {0,1,2},
                        {3,4,5},
                        {6,7,8} };
        System.out.println(Arrays.deepToString(Problem7_RotateMatrix.rotate(mat)));
    }
}

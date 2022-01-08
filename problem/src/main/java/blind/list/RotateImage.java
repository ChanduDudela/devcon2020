package blind.list;

public class RotateImage {
    // transpose
    // reflect columns

    public void rotate(int[][] matrix) {
        // transpose
        transpose(matrix);

        // reflect columns
        reflectColumns(matrix);
    }

    void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[i][j] = temp;
            }
        }
    }

    void reflectColumns(int[][] matrix) {
           int start = 0;
           int end = matrix[0].length-1;

           while (start < end) {
               for (int i = 0; i < matrix.length; i++) {
                   int temp = matrix[i][start];
                   matrix[i][start] = matrix[i][end];
                   matrix[i][end] = temp;
               }

               start++;
               end--;
           }
    }
}

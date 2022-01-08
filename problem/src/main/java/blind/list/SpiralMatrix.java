package blind.list;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }

        int rowMin = 0;
        int rowMax = matrix.length-1;
        int colMin = 0;
        int colMax = matrix[0].length-1;

        while (rowMin <= rowMax && colMin <= colMax) {
            for (int i = colMin; i <= colMax; i++) {
                res.add(matrix[rowMin][i]);
            }
            rowMin++;

            for (int i = rowMin; i <= rowMax; i++) {
                res.add(matrix[i][colMax]);
            }
            colMax--;

            if (rowMin <= rowMax) {
                for (int i = colMax; i >= colMin; i--) {
                    res.add(matrix[rowMax][i]);
                }
                rowMax--;
            }


            if (colMin <= colMax) {
                for (int i = rowMax; i >= rowMin; i--) {
                    res.add(matrix[i][colMin]);
                }
                colMin++;
            }
        }

        return res;
    }
}

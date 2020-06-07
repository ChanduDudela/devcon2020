package aws.onlineassesment;

public class GenerateSpiralMatrix {

    public int[][] generateMatrix(int n) {
        int[][] resultArr = new int[n][n];

        int rowsBegin = 0;
        int rowsEnd = n - 1;
        int colsBegin = 0;
        int colsEnd = n - 1;

        int num = 1;

        while (rowsBegin <= rowsEnd && colsBegin <= colsEnd) {
            for (int i = colsBegin; i <= colsEnd; i++) {
                resultArr[rowsBegin][i] = ++num;
            }
            rowsBegin++;

            for (int i = rowsBegin; i <= rowsEnd; i++) {
                resultArr[i][colsEnd] = ++num;
            }
            colsEnd--;

            if (rowsBegin <= rowsEnd) {
                for (int i = colsEnd; i >= colsBegin; i--) {
                    resultArr[rowsEnd][i] = ++num;
                }
            }
            rowsEnd--;

            if (colsBegin <= colsEnd) {
                for (int i = rowsEnd; i >= rowsBegin; i--) {
                    resultArr[i][colsBegin] = ++num;
                }
            }
            colsBegin++;
        }
        return resultArr;
    }
}

package aws.onlineassesment;

//https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchA2x2Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0){
            return false;
        }

        int row = matrix.length -1;
        int col = 0;

        while(row >= 0 && col <= matrix[0].length-1){
            if(target < matrix[row][col]){
                row--;
            } else if(target > matrix[row][col]){
                col++;
            } else {
                return true;
            }
        }

        return false;
    }
}

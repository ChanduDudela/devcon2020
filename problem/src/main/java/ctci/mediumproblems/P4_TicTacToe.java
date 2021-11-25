package ctci.mediumproblems;

public class P4_TicTacToe {

    int[][] board;
    int[] rowSum; // maintain the sum for each row
    int[] colSum; // maintain the sum for each column
    int topLeftDiagonal = 0;
    int topRightDiagonal = 0;

    public P4_TicTacToe(int[][] board) {
        this.board = board;

        rowSum = new int[board.length];
        colSum = new int[board.length];
    }

    int move(int row, int col, int player) throws Exception {
        if (row < 0 || row > board.length - 1 || col < 0 || col > board.length -1) {
            throw new Exception("out of bounds");
        }

        rowSum[row] += player == 1 ? 1 : -1;
        colSum[row] += player == 1 ? 1 : -1;

        if (row == col) {
            topLeftDiagonal += player == 1 ? 1 : -1;
        } else if (row + col == board.length-1) {
            topRightDiagonal += player == 1 ? 1 : -1;
        }

        return hasWon(row, col);
    }

    int hasWon(int row, int col) {
        if (rowSum[row] == board.length
            || colSum[col] == board.length
            || topLeftDiagonal == board.length
            || topRightDiagonal == board.length) {
            return 1;
        }
        if (rowSum[row] == -board.length
            || colSum[col] == -board.length
            || topLeftDiagonal == -board.length
            || topRightDiagonal == -board.length) {
            return -1;
        }
        return 2;
    }
}

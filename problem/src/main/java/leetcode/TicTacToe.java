package leetcode;

public class TicTacToe {

    /** Initialize your data structure here. */

    int[] rows;
    int[] cols;

    int topLeftToRight;
    int topRightToLeft;
    int boardSize;


    public TicTacToe(int boardSize) {
        rows = new int[boardSize];
        cols = new int[boardSize];
        this.boardSize = boardSize;

        topLeftToRight = 0;
        topRightToLeft = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {

        rows[row] += player == 1? 1 : -1;
        cols[col] += player == 1? 1 : -1;

        if(row == col){
            topLeftToRight += player == 1? 1 : -1;
        }
        if(row + col == boardSize - 1){
            topRightToLeft += player == 1? 1 : -1;
        }

        if(rows[row] == boardSize || cols[col] == boardSize || topLeftToRight == boardSize
           || topRightToLeft == boardSize){
            return 1;
        }
        if(rows[row] == -boardSize || cols[col] == -boardSize || topLeftToRight == -boardSize
           || topRightToLeft == -boardSize){
            return 2;
        }

        return 0;
    }
}

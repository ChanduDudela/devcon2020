package aws.random.questions;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        int boardLength = board.length;

        if(boardLength == 0){
            return 0;
        }

        //Create 1D array of the board
        int[] boardArr = new int[boardLength * boardLength + 1];

        //Fill up this 1D array with the board values
        boolean leftToRight = true;
        int idx = 1;

        for(int i = boardLength-1; i >= 0; i--) {
            if(leftToRight) {
                for(int j =0; j < boardLength; j++){
                    boardArr[idx++] = board[i][j];
                }
            } else{
                for(int j = boardLength -1; j >= 0; j--){
                    boardArr[idx++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }

        //Apply bfs
        Queue<Integer> pq = new LinkedList<>();
        boolean[] visited = new boolean[boardLength * boardLength + 1];

        // start from square 1
        pq.offer(1);
        int turns = 1;
        visited[1] = true;

        while(!pq.isEmpty()){
            int size = pq.size();

            for(int i =0; i < size; i ++){
                int square = pq.poll();

                for(int j =1; j <= 6; j++){
                    int newSquare = square + j;

                    if(boardArr[newSquare] != -1){
                        newSquare = boardArr[newSquare];
                    }

                    if (visited[newSquare]) {
                        continue;
                    }

                    if(newSquare == boardLength * boardLength){
                        return turns;
                    }

                    visited[newSquare] = true;
                    pq.offer(newSquare);
                }
            }
            turns++;
        }

        return -1;
    }
}

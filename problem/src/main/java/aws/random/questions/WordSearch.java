package aws.random.questions;

class WordSearch {

    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        visited = new boolean[board.length][board[0].length];

        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }


    private boolean dfs(char[][] board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }

        if(i < 0 || j < 0 || i > board.length -1 || j > board[0].length -1 || visited[i][j]
           || board[i][j] != word.charAt(index)){

            return false;
        }

        visited[i][j] = true;

        if(dfs(board, word, i+1, j, index+1)
           || dfs(board, word, i-1, j, index+1)
           || dfs(board, word, i, j+1, index+1)
           || dfs(board, word, i, j-1, index+1)){

            return true;
        }

        //(Set to false for backtracking)
        //After you have tried all the neighbors of the board[i][j] and couldn't find the matches,
        //then you have to search the word from another position.
        //let's say that position is board[m][n]. so from board[m][n] perspective,
        // it hasn't visited board[i][j], so you have to set visited[i][j] back to false to allow other calls use it.
        visited[i][j] = false;

        return false;
    }

}

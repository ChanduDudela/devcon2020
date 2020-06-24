package aws.random.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/number-of-distinct-islands/
// By Path Signature approach
public class DistinctIslands_medium {

    public int numDistinctIslands(int[][] grid) {
        //for storing the unique path of the islands
        Set<List<Integer>> pathSet = new HashSet<>();

        for(int i =0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    List<Integer> pathList = new ArrayList<>();

                    dfs(i, j, grid, pathList, 0);

                    pathSet.add(pathList);
                }
            }
        }

        return pathSet.size();
    }

    private void dfs(int i, int j, int[][] grid, List<Integer> pathList, int direction) {

        if(i < 0 || j < 0 || i > grid.length -1 || j > grid[0].length -1 || grid[i][j] == 0){
            return;
        }

        pathList.add(direction);

        grid[i][j] = 0;

        dfs(i+1, j, grid, pathList, 1);
        dfs(i-1, j, grid, pathList, 2);
        dfs(i, j+1, grid, pathList, 3);
        dfs(i, j-1, grid, pathList, 4);

        pathList.add(0);
    }
}

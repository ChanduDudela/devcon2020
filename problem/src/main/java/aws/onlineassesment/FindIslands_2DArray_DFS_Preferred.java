package aws.onlineassesment;

public class FindIslands_2DArray_DFS_Preferred {

    /**
     * Given a 2d grid map of '1's (land) and '0's (water),
     * count the number of islands.
     *
     * This method approaches the problem as one of depth-first connected
     * components search
     *
     * @param grid, the given grid.
     * @return the number of islands.
     */
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (grid[i][j] == '1') {
                    recursive_dfs(grid, i, j);
                    ++count;
                }
            }
        }

        return count;
    }

    /**
     * Marks the given site as visited, then checks adjacent sites.
     *
     * Or, Marks the given site as water, if land, then checks adjacent sites.
     *
     * Or, Given one coordinate (i,j) of an island, obliterates the island
     * from the given grid, so that it is not counted again.
     *
     * @param i, the row index of the given grid
     * @param j, the column index of the given grid
     */
    private void recursive_dfs(char[][] grid, int i, int j) {

        // Check for invalid indices and for sites that are water
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        // Mark the site as visited (water) - this is basically a 'visited' flag
        grid[i][j] = '0';

        // Check all adjacent sites
        recursive_dfs(grid, i-1, j);
        recursive_dfs(grid, i+1, j);
        recursive_dfs(grid, i, j+1);
        recursive_dfs(grid, i, j-1);
    }
}

package aws.onlineassesment;

import java.util.LinkedList;
import java.util.Queue;

public class FindIslands_2DArray_BFS {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int count = 0;

        Queue<int[]> islandsQ = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (grid[i][j] == '1') {
                    islandsQ.offer(new int[]{i, j});
                    bfs(grid, islandsQ);
                    ++count;
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, Queue<int[]> islandsQ) {
        int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int rows = grid.length;
        int columns = grid[0].length;

        while (!islandsQ.isEmpty()) {
            int size = islandsQ.size();

            for (int i = 0; i < size; i++) {
                int[] x = islandsQ.poll();
                for (int[] dir : direction) {
                    int y = x[0] + dir[0];
                    int z = x[1] + dir[1];
                    if (y < 0 || z < 0 || y >= rows || z >= columns || grid[y][z] == '0') {
                        continue;
                    }

                    grid[y][z] = '0';
                    islandsQ.offer(new int[] {y, z});
                }
            }
        }
    }
}

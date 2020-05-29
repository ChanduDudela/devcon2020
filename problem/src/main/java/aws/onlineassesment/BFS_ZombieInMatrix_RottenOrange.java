package aws.onlineassesment;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/discuss/interview-question/411357/
public class BFS_ZombieInMatrix_RottenOrange {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 0, 1},
                        {0, 1, 0, 1, 0},
                        {0, 0, 0, 0, 1},
                        {0, 1, 0, 0, 0}};

        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        Queue<int[]> rottenOrangesQ = new LinkedList<>();
        int freshOranges = 0;

        //pick the location of rotten oranges and put it in a Queue (BFS)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2) {
                    rottenOrangesQ.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    ++freshOranges;
                }
            }
        }

        // No fresh Oranges in the grid
        if (freshOranges == 0) {
            return 0;
        }
        int[][] direction = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int minutes = 0;

        //apply bfs
        while (!rottenOrangesQ.isEmpty()) {
            ++minutes;

            int size = rottenOrangesQ.size();
            for(int i = 0 ; i < size ; i++) {
                int[] rottenOrange = rottenOrangesQ.poll();

                for (int[] dir : direction) {
                    int x = dir[0] + rottenOrange[0];
                    int y = dir[1] + rottenOrange[1];

                    if (x < 0 || y < 0 || x >= rows || y >= columns || grid[x][y] == 0
                        || grid[x][y] == 2) {
                        continue;
                    }
                    grid[x][y] = 2;
                    rottenOrangesQ.offer(new int[] {x, y});
                    --freshOranges;
                }
            }
        }

        return freshOranges > 0 ? -1: minutes-1;
    }
}

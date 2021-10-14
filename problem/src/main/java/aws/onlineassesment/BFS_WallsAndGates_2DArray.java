package aws.onlineassesment;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/walls-and-gates/
public class BFS_WallsAndGates_2DArray {
    public static void main(String[] args) {
        int[][] grid = {{2147483647, -1, 0, 2147483647},
            {2147483647, 2147483647, 2147483647, -1},
            {2147483647, -1, 2147483647, -1},
            {0, -1, 2147483647, 2147483647}};

        wallsAndGates(grid);
    }

    public static void wallsAndGates(int[][] grid) {
        if (grid.length == 0) {
            System.out.println("NO DATA");
            return;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        int emptyRooms = 0;
        Queue<int[]> gatesQ = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0) {
                    gatesQ.offer(new int[] {i, j});
                } else if (grid[i][j] == 2147483647) {
                    ++emptyRooms;
                }
            }
        }
        if (emptyRooms == 0) {
            System.out.println("No empty rooms to fill.");
            return;
        }
        int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        while (!gatesQ.isEmpty()) {
            int size = gatesQ.size();

            for (int i = 0; i < size; i++) {
                int[] gateIndex = gatesQ.poll();
                for (int[] dir : direction) {
                    int x = dir[0] + gateIndex[0];
                    int y = dir[1] + gateIndex[1];

                    if (x < 0 || y < 0 || x >= rows || y >= columns || grid[x][y] != 2147483647) {
                        continue;
                    }
                    grid[x][y] = grid[gateIndex[0]][gateIndex[1]] + 1;
                    gatesQ.offer(new int[] {x, y});
                }
            }
        }
    }
}

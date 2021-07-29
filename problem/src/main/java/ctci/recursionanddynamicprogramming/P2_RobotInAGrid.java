package ctci.recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P2_RobotInAGrid {
    List<int[]> getPathToTarget(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] source = {0, 0};
        int redZone = -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(source);
        List<int[]> journey = new ArrayList<>();

        while (!queue.isEmpty()) {
            int cells = queue.size();

            for (int i = 0; i < cells; i++) {
                int[] cell = queue.poll();

                if (cell[0] == rows - 1 && cell[1] == cols - 1) {
                    //destination reached
                    journey.add(new int[] {cell[0], cell[1]});
                    return journey;
                } else if (grid[cell[0]][cell[1]] != redZone) {
                    journey.add(new int[] {cell[0], cell[1]});

                    queue.offer(new int[] {cell[0] + 1, cell[1]});
                    queue.offer(new int[] {cell[0], cell[1] + 1});
                }
            }
        }

        // no path
        return null;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // 2 power (rows + cols) runtime because of each cell yields to 2 paths.
    ArrayList<Point> getPathToDestination(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }

        ArrayList<Point> path = new ArrayList<>();
        if (getPath(grid, grid.length - 1, grid[0].length - 1, path)) {
            return path;
        }

        return null;
    }

    boolean getPath(boolean[][] grid, int row, int col, ArrayList<Point> path) {
        if (row < 0 || col < 0 || !grid[row][col]) {
            return false;
        }

        boolean isDestination = (row == 0) && (col == 0);

        if (isDestination
            || getPath(grid, row - 1, col, path)
            || getPath(grid, row, col - 1, path)) {

            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }

    // using memoization, runtime comes down to  O(r * c) because cells won't be revisited.
    ArrayList<Point> getPathToDestination_Memoize(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }

        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> duplicatesSet = new HashSet<>();

        if (getPath_Memoize(grid, grid.length - 1, grid[0].length - 1, path, duplicatesSet)) {
            return path;
        }

        return null;
    }

    boolean getPath_Memoize(
        boolean[][] grid, int row, int col, ArrayList<Point> path, HashSet<Point> duplicatesSet) {
        if (row < 0 || col < 0 || !grid[row][col]) {
            return false;
        }

        Point p = new Point(row, col);
        if (duplicatesSet.contains(p)) {
            return false;
        }

        boolean isDestination = (row == 0) && (col == 0);

        if (isDestination
            || getPath_Memoize(grid, row - 1, col, path, duplicatesSet)
            || getPath_Memoize(grid, row, col - 1, path, duplicatesSet)) {

            path.add(p);
            return true;
        }

        duplicatesSet.add(p);
        return false;
    }
}

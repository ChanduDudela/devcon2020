package ctci.recursionanddynamicprogramming;

public class P10_PaintFill {

    enum COLOR { GREEN, PINK, ORANGE }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    void paintFill(COLOR[][] grid, COLOR newColor, Point p) {
        if (grid[p.row][p.col] == newColor) {
            return;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        dfs(grid, grid[p.row][p.col], newColor, rows, cols, p);
    }

    void dfs(COLOR[][] grid, COLOR oldColor, COLOR newColor, int rows, int cols, Point point) {
        if (point.row < 0 || point.row > rows || point.col < 0 || point.col > cols) {
            return;
        }

        if (grid[point.row][point.col] == oldColor) {
            grid[point.row][point.col] = newColor;

            dfs(grid, oldColor, newColor, rows, cols, new Point(point.row - 1, point.col));
            dfs(grid, oldColor, newColor, rows, cols, new Point(point.row + 1, point.col));
            dfs(grid, oldColor, newColor, rows, cols, new Point(point.row, point.col + 1));
            dfs(grid, oldColor, newColor, rows, cols, new Point(point.row, point.col - 1));
        }
    }
}

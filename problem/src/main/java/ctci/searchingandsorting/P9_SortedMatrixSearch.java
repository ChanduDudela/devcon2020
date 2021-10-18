package ctci.searchingandsorting;

public class P9_SortedMatrixSearch {
    public static void main(String[] args) {
        int[][] grid =
            {{15, 20, 70, 85},
            {20, 35, 80, 95},
            {30, 55, 9, 105},
            {40, 80, 100, 120}};

        System.out.println(new P9_SortedMatrixSearch().findElement(grid, 121));
    }

    public boolean findElement(int[][] grid, int element) {
        if (grid == null || grid.length == 0) {
            return false;
        }

        int row = 0;
        int col = grid[0].length - 1;

        while (row < grid.length && col >=0) {
            if (grid[row][col] == element) {
                return true;
            } else if (grid[row][col] > element) {
                col--;
            } else {
                row ++;
            }
        }

        return false;
    }
}

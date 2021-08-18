package ctci.mediumproblems;

import java.util.ArrayList;
import java.util.List;

public class PondSize {
    List<Integer> getPondSizes (int[][] plot) {
        if (plot == null || plot.length == 0) {
            return null;
        }

        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[plot.length][plot[0].length];

        for (int i = 0; i < plot.length; i++) {
            for (int j = 0; j < plot[0].length; j++) {
                int pondSize = compute(i, j, plot, visited);

                if (pondSize != 0) {
                    result.add(pondSize);
                }
            }
        }

        return result;
    }

    int compute(int row, int col, int[][] plot, boolean[][] visited) {
        if (row < 0 || row > plot.length || col < 0 || col > plot[0].length || visited[row][col]
            || plot[row][col] != 0) {
            return 0;
        }

        visited[row][col] = true;
        int size = 1;
        for (int i = -1; i < 1; i++) {
            for (int j = -1; j < 1; j++) {
                size += compute(i + row, j + col, plot, visited);
            }
        }

        return size;
    }
}

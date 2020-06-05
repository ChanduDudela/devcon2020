package aws.onlineassesment;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/discuss/interview-question/347457
public class BFS_TreasureIsland {

    public static int treasureIsland(char[][] island) {
        int rows = island.length;
        int cols = island[0].length;

        Queue<int[]> pathList = new LinkedList<>();
        pathList.add(new int[] {0, 0});

        int steps = 0;
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        boolean[][] visitedArray = new boolean[rows][cols];
        visitedArray[0][0] = true;

        while (!pathList.isEmpty()) {
            int size = pathList.size();

            for (int i = 0; i < size; i++) {
                int[] path = pathList.poll();

                if (island[path[0]][path[1]] == 'X') {
                    return steps;
                }

                for (int[] dir : directions) {
                    int x = dir[0] + path[0];
                    int y = dir[1] + path[1];

                    if (x >= 0 && x < rows && y >= 0 && y < cols && island[x][y] != 'D'
                        && !visitedArray[x][y]) {
                        pathList.add(new int[] {x, y});
                        visitedArray[x][y] = true;
                    }
                }
            }
            ++steps;
        }
        return steps;
    }

    //Multiple Sources - https://leetcode.com/discuss/interview-question/356150
    public static int treasureIslandMultipleSources(char[][] island) {
        int rows = island.length;
        int cols = island[0].length;

        Queue<int[]> pathList = new LinkedList<>();
        boolean[][] visitedArray = new boolean[rows][cols];

        //Add all the sources to the Queue and mark them visited
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (island[i][j] == 'S') {
                    pathList.add(new int[] {i, j});
                    visitedArray[i][j] = true;
                }
            }
        }

        int steps = 0;
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        while (!pathList.isEmpty()) {
            int size = pathList.size();

            for (int i = 0; i < size; i++) {
                int[] path = pathList.poll();

                if (island[path[0]][path[1]] == 'X') {
                    return steps;
                }

                for (int[] dir : directions) {
                    int x = dir[0] + path[0];
                    int y = dir[1] + path[1];

                    if (x >= 0 && x < rows && y >= 0 && y < cols && island[x][y] != 'D'
                        && !visitedArray[x][y]) {
                        pathList.add(new int[] {x, y});
                        visitedArray[x][y] = true;
                    }
                }
            }
            ++steps;
        }
        return steps;
    }
}

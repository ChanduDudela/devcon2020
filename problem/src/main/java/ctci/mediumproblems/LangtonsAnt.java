package ctci.mediumproblems;

import java.util.HashSet;
import java.util.Objects;

public class LangtonsAnt {
    public enum Orientation {
        up, down, right, left;

        Orientation turn(boolean clockwise) {
            if (this == up) {
                return clockwise ? right : left;
            } else if (this == right) {
                return clockwise ? down : up;
            } else if (this == down) {
                return clockwise ? left : right;
            } else {
                return clockwise ? up : down;
            }
        }
    }

    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Position position = (Position) o;
            return row == position.row && col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    static class Ant {
        Position position = new Position(0, 0);
        Orientation orientation = Orientation.right;

        void changeOrientation (boolean clockwise) {
            orientation = orientation.turn(clockwise);
        }

        void move() {
            if (orientation == Orientation.left) {
                position.col--;
            } else if (orientation == Orientation.right) {
                position.col++;
            } else if (orientation == Orientation.up) {
                position.row--;
            } else {
                position.row++;
            }
        }
    }

    static class Board {
        Ant ant = new Ant();
        HashSet<Position> blackCells = new HashSet<>();
        Position maxTopLeft = new Position(0, 0);
        Position maxBottomRight = new Position(0, 0);

        void flipColor(Position p) {
            if (blackCells.contains(p)) {
                blackCells.remove(p);
            } else {
                blackCells.add(p);
            }
        }

        boolean isBlack (Position p) {
            return blackCells.contains(p);
        }

        boolean isBlack(int row, int col) {
            return blackCells.contains(new Position(row, col));
        }

        void ensureFit(Position p) {
            int newMaxTopLeftRow = Math.min(maxTopLeft.row, p.row);
            int newMaxTopLeftCol = Math.min(maxTopLeft.col, p.col);
            maxTopLeft.row = newMaxTopLeftRow;
            maxTopLeft.col = newMaxTopLeftCol;

            int newMaxBottomRightRow = Math.max(maxBottomRight.row, p.row);
            int newMaxBottomRightCol = Math.max(maxBottomRight.col, p.col);
            maxBottomRight.row = newMaxBottomRightRow;
            maxBottomRight.col = newMaxBottomRightCol;
        }

        void move () {
            ant.changeOrientation(!isBlack(ant.position)); // if black, then counter clock-wise
            flipColor(ant.position);
            ant.move();
            ensureFit(ant.position);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            int rowMin = maxTopLeft.row;
            int rowMax = maxBottomRight.row;
            int colMin = maxTopLeft.col;
            int colMax = maxBottomRight.col;

            for (int i = rowMin; i <= rowMax; i++) {
                for (int j = colMin; j <= colMax; j++) {
                    if (ant.position.row == i && ant.position.col == j) {
                        sb.append(ant.orientation);
                    } else if (isBlack(i, j)) {
                        sb.append("X");
                    } else {
                        sb.append("_");
                    }
                }
                sb.append("\n");
            }

            return sb.toString();
        }
    }
}

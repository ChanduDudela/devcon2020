package random;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int distFromOrigin() {
        // ignoring sqrt
        return (x * x) + (y * y);
    }
}

public class KClosestPointsToOrigin {
    public static List<Point> findClosestPoints(Point[] points, int k) {

        // Max Heap - Descending order - Highest distance (top) to lowest distance
        Queue<Point> maxHeap =
            new PriorityQueue<>((p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());

        for(Point p: points){
            maxHeap.add(p);

            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 2), new Point(1, 3)};
        List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 1);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result)
            System.out.print("[" + p.x + " , " + p.y + "] ");
    }
}

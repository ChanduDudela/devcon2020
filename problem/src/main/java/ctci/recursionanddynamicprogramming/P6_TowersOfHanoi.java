package ctci.recursionanddynamicprogramming;

import java.util.Stack;

/**
 * 1. move n-1 disks from source to buffer, using dest as buffer
 * 2. move top disc from source to destination
 * 3. move n-1 disks from buffer to destination, using source as buffer
 */
public class P6_TowersOfHanoi {
    static class Tower {
        Stack<Integer> disks = new Stack<>();

        void add(int disc) {
            if (!disks.isEmpty() && disks.peek() < disc) {
                System.out.println("Error. Can't place bigger disc on smaller disc");
            }
            disks.push(disc);
        }

        void moveTopTo(Tower t) {
            int topDisk = disks.pop();
            t.add(topDisk);
        }

        void moveDisks(int quantity, Tower destination, Tower buffer) {
            if (quantity <= 0) {
                return;
            }

            // move using buffer as destination, destination as buffer
            moveDisks(quantity - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(quantity-1, destination, this);
        }
    }
}

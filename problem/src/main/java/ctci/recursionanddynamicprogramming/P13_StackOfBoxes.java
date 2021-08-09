package ctci.recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.Comparator;

public class P13_StackOfBoxes {
    static class Box {
        int height;
        int width;
        int depth;

        boolean canBeAbove(Box b2) {
            return b2.height > this.height;
        }
    }

    static class BoxComparator implements Comparator<Box> {
        @Override
        public int compare(Box o1, Box o2) {
            return o2.height - o1.height;
        }
    }

    int createStack(ArrayList<Box> boxes) {
        boxes.sort(new BoxComparator());
        int[] maxHeightCache = new int[boxes.size()+1];

        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i, maxHeightCache);
            maxHeight = Math.max(maxHeight, height);
        }

        return maxHeight;
    }

    int createStack(ArrayList<Box> boxes, int bottomBoxIndex, int[] maxHeightCache) {
        if (maxHeightCache[bottomBoxIndex] > 0) {
            return maxHeightCache[bottomBoxIndex];
        }

        Box bottomBox = boxes.get(bottomBoxIndex);

        int maxHeight = 0;
        for (int i = bottomBoxIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottomBox)) {
                int height = createStack(boxes, i, maxHeightCache);
                maxHeight = Math.max(maxHeight, height);
            }
        }

        maxHeight = bottomBox.height;
        maxHeightCache[bottomBoxIndex] = maxHeight;

        return maxHeight;
    }
}

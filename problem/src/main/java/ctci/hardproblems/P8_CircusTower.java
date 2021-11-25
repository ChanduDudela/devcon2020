package ctci.hardproblems;

import java.util.ArrayList;
import java.util.Collections;

public class P8_CircusTower {
    static class HtWt implements Comparable<HtWt>{
        int height;
        int weight;

        public HtWt(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(HtWt o) {
            if (this.height != o.height) {
                return Integer.compare(this.height, o.height);
            } else {
                return Integer.compare(this.weight, o.weight);
            }
        }

        public boolean isBefore(HtWt other) {
            return this.height < other.height && this.weight < other.weight;
        }
    }

    ArrayList<HtWt> longestIncreasingSequence (ArrayList<HtWt> array) {
        Collections.sort(array); // sorting by Height. If same height, sort by weight

        ArrayList<ArrayList<HtWt>> longestSubsequenceByIndex = new ArrayList<>();
        ArrayList<HtWt> longestIncreasingSequence = null;

        for (int i = 0; i < array.size(); i++) {
            ArrayList<HtWt> seqAtIndex = calculateSequenceAtIndex(array, i, longestSubsequenceByIndex);
            longestSubsequenceByIndex.add(i, seqAtIndex);

            longestIncreasingSequence = getMaxList(longestIncreasingSequence, seqAtIndex);
        }

        return longestIncreasingSequence;
    }

    ArrayList<HtWt> calculateSequenceAtIndex(
        ArrayList<HtWt> array, int index, ArrayList<ArrayList<HtWt>> solution) {

        HtWt current = array.get(index);

        ArrayList<HtWt> currentList = new ArrayList<>();

        for (int i = 0; i < index; i++) {
            ArrayList<HtWt> sol = solution.get(i);
            if (canAppend(sol, current)) {
                currentList = getMaxList(sol, currentList);
            }
        }

        ArrayList<HtWt> clone = (ArrayList<HtWt>) currentList.clone();
        clone.add(current);

        return clone;
    }

    public boolean canAppend(ArrayList<HtWt> list, HtWt other) {
        if (list.size() == 0) {
            return true;
        }
        return list.get(list.size() -1).isBefore(other);
    }

    ArrayList<HtWt> getMaxList (ArrayList<HtWt> li1, ArrayList<HtWt> li2) {
        return li1 != null && li1.size() >= li2.size() ? li1 : li2;
    }
}

package aws.onlineassesment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//https://leetcode.com/problems/prison-cells-after-n-days/
public class PrisonCellsAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int N) {

        Set<String> uniqueStrings = new HashSet<>();

        int[] cellsCopy = new int[cells.length+2];


        //counter to track which iteration the cycle is encountered
        int count = 0;
        boolean hasCycle = false;

        for (int i = 1; i <= N; i++) {
            int[] newVals = nextDayValue(cells);
            String strWithNewVals = Arrays.toString(newVals);

            if (!uniqueStrings.contains(strWithNewVals)) {
                count++;
                uniqueStrings.add(strWithNewVals);
            } else {
                hasCycle = true;
                break;
            }

            cells = newVals;
        }

        //If cycle was found, then just execute for N % count times (not the whole N times)
        if (hasCycle) {
            N = N % count;
            for (int i = 1; i <= N; i++) {
                cells = nextDayValue(cells);
            }
        }

        return cells;
    }

    private int[] nextDayValue(int[] prevDayValue) {
        int[] newVals = new int[prevDayValue.length];

        for (int i = 1; i < prevDayValue.length - 1; i++) {
            newVals[i] = prevDayValue[i - 1] == prevDayValue[i + 1] ? 1 : 0;
        }
        return newVals;
    }
}

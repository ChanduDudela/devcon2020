package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times [s1, e1], [s2, e2], ... ,
 * determine if a person could attend all meetings.
 *
 * For example,
 * Given [ [0, 30], [5, 10], [15, 20] ],
 * return false.
 *
 * https://leetcode.com/problems/meeting-rooms/
 */
public class MeetingRoom_1_easy {

    public boolean canAttendMeetings(int[][] intervals) {
        // Sort by the meeting start times
        Arrays.sort(intervals, Comparator.comparingInt(slot -> slot[0]));

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }

        return true;
    }
}

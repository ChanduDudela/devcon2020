package leetcode;

import java.util.Arrays;

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
        Arrays.sort(intervals, (slot1, slot2) -> slot1[0] - slot2[0]);

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }

        return true;
    }
}

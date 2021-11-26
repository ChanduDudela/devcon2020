package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/meeting-rooms-ii/
public class MeetingRoom_2_medium {

    public int minMeetingRooms(int[][] intervals) {

        if(intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Queue<Integer> minHeapMeetingsQ = new PriorityQueue<>(intervals.length, (a, b) -> a - b);

        //Add end time of the first meeting to the min heap
        minHeapMeetingsQ.offer(intervals[0][1]);

        // if start time of next meeting is before the time of the meeting in queue
        for (int i = 1; i <= intervals.length - 1; i++) {
            if (intervals[i][0] >= minHeapMeetingsQ.peek()) {
                minHeapMeetingsQ.poll();
            }

            minHeapMeetingsQ.offer(intervals[i][1]);
        }

        return minHeapMeetingsQ.size();
    }
}

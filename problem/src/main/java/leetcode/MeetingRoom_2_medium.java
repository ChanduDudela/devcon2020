package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/meeting-rooms-ii/
// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
// find the minimum number of conference rooms required.
public class MeetingRoom_2_medium {

    // method - 1
    public static int minMeetingRooms2(int[][] intervals) {
        if(intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] prev = intervals[0];
        int rooms = 1;

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            if (prev[1] > curr[0]) {
                rooms++;
            }
            prev = curr;
        }

        return rooms;
    }

    // method - 2
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

    public static void main(String[] args) {
        //int[][] arr = {{0,30},{5,10},{15,20}};
        int[][] arr = {{2, 7}};
        System.out.println(MeetingRoom_2_medium.minMeetingRooms2(arr));
    }
}

package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/meeting-rooms/
public class MeetingRoom_1_easy {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for(int i =0; i < intervals.length -1; i++){
            if(intervals[i][1] > intervals[i+1][0]){
                return false;
            }
        }

        return true;
    }
}

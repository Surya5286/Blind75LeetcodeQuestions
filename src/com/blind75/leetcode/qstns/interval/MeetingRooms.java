package com.blind75.leetcode.qstns.interval;

import java.util.Arrays;

public class MeetingRooms {

    public static void main(String[] args) {

        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(canAttendMeetings(intervals)); // Output: false
    }

    private static boolean canAttendMeetings(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return true;
        }

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < end) {
                return false;
            }
            end = Math.max(end, intervals[i][1]);
        }

        return true;
    }
}

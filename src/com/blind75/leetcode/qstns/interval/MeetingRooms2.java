package com.blind75.leetcode.qstns.interval;

import java.util.Arrays;

public class MeetingRooms2 {

    public static void main(String[] args) {

        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        int result = getNumberOfMeetingRoomsRequired(intervals);
        System.out.println(result); // Output: 2
    }

    private static int getNumberOfMeetingRoomsRequired(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int roomsRequired = 0;
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int endPointer = 0;

        for (int i = 0; i < startTimes.length; i++) {
            if (startTimes[i] < endTimes[endPointer]) {
                roomsRequired++;
            } else {
                endPointer++;
            }
        }

        return roomsRequired;
    }
}

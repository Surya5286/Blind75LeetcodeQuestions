package com.blind75.leetcode.qstns.interval;

import java.util.Arrays;

public class CountNonoverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int result = countNonOverlappingIntervalsToRemove(intervals);
        System.out.println("Count of Non-Overlapping Intervals: " + result);
    }

    /*
        Optimal Approach:
        Time Complexity: O(N log N) due to sorting the intervals.
        Space Complexity: O(1) if we ignore the input storage.

        Intuition:
        To find the minimum number of intervals to remove & to make the rest non-overlapping,
          Say given Input - {1, 2}, {2, 3}, {3, 4}, {1, 3}

          Sort the intervals based on their end times:
          After sorting: {1, 2}, {1, 3}, {2, 3}, {3, 4}

          Now, we can iterate through the sorted intervals and keep track of the end time of the last added interval.
            If the start time of the current interval is less than the end time of the last added interval,
                it means there is an overlap, and we need to remove the current interval.
                - We can keep {1, 2}, {2, 3}, {3, 4} and remove {1, 3}
          So, the count of intervals to remove is 1.
    */
    private static int countNonOverlappingIntervalsToRemove(int[][] intervals) {

        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if(intervals[i][0] < end)
                count++;
            else
                end = intervals[i][1];
        }

        return count;
    }
}

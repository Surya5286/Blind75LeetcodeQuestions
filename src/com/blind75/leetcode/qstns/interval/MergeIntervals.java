package com.blind75.leetcode.qstns.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {2, 6}, {5, 8}, {8, 10}, {15, 18}};
        int[][] result = mergeIntervalsUsingBruteForceApproach(intervals);
        System.out.println("Merged Intervals using Brute Force Approach: " + Arrays.deepToString(result));

        result = mergeIntervalsUsingOptimalApproach(intervals);
        System.out.println("Merged Intervals using Optimal Approach: " + Arrays.deepToString(result));
    }

    /*
        Brute Force Approach:
        Time Complexity: O(N^2) - for every interval we check all future intervals
        Space Complexity: O(N) for storing the merged intervals.

    */
    private static int[][] mergeIntervalsUsingBruteForceApproach(int[][] intervals) {

        if (intervals == null || intervals.length == 0)
            return new int[0][];

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i+1;

            while (j<n && intervals[j][0] <= end) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            // Add the merged interval to the result list
            result.add(new int[]{start, end});

            // Move to the next interval
            i = j;
        }

        return result.toArray(new int[result.size()][]);
    }


    /*
        Optimal Approach:
        Time Complexity: O(N log N) due to sorting the intervals.
        Space Complexity: O(N) for storing the merged intervals.

    */
    private static int[][] mergeIntervalsUsingOptimalApproach(int[][] intervals) {

        if (intervals == null || intervals.length == 0)
            return new int[0][];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int[] lastInterval = result.getLast();

            if(intervals[i][0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}

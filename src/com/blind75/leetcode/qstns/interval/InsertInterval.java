package com.blind75.leetcode.qstns.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] intervals2 = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = new int[]{4, 8};

        int[][] result = insertIntervalUsingBetterApproach(intervals, newInterval);
        System.out.println("Merged Intervals Using Better Approach: " + Arrays.deepToString(result));

        int[][] result2 = insertIntervalUsingBetterApproach(intervals2, newInterval2);
        System.out.println("Merged Intervals Using Better Approach: " + Arrays.deepToString(result2));

        result = insertIntervalUsingOptimalApproach(intervals, newInterval);
        System.out.println("Merged Intervals Using Optimal Approach: " + Arrays.deepToString(result));

        result2 = insertIntervalUsingOptimalApproach(intervals2, newInterval2);
        System.out.println("Merged Intervals Using Optimal Approach: " + Arrays.deepToString(result2));
    }

    /*
        Better Approach:
        Time Complexity: O(N log N) due to sorting the intervals.
        Space Complexity: O(N) for storing the merged intervals.

    */
    private static int[][] insertIntervalUsingBetterApproach(int[][] intervals, int[] newInterval) {

        // Edge case: if intervals is empty, return newInterval as the only interval
        if (intervals == null || intervals.length == 0)
            return new int[][]{newInterval};

        // Combine the new interval with existing intervals
        List<int[]> combinedInterval = new ArrayList<>(Arrays.asList(intervals));

        // Add the new interval to the list
        combinedInterval.add(newInterval);

        return mergeIntervals(combinedInterval);
    }

    private static int[][] mergeIntervals(List<int[]> combinedInterval) {

        if (combinedInterval == null || combinedInterval.isEmpty())
            return new int[0][];

        // Sort the intervals based on the start time
        combinedInterval.sort(Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        result.add(combinedInterval.getFirst());

        for (int i = 1; i < combinedInterval.size(); i++) {

            int[] existingInterval = result.getLast();
            if (existingInterval[1] >= combinedInterval.get(i)[0]) {
                existingInterval[1] = Math.max(existingInterval[1], combinedInterval.get(i)[1]);
            } else {
                result.addLast(combinedInterval.get(i));
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    /*
        Optimal Approach:
        Time Complexity: O(N) where N is the number of intervals.
        Space Complexity: O(N) for storing the merged intervals.
     */
    private static int[][] insertIntervalUsingOptimalApproach(int[][] intervals, int[] newInterval) {

        if (intervals == null || intervals.length == 0)
            return new int[][]{newInterval};

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        List<int[]> result = new ArrayList<>();
        boolean isInserted = false;

        for (int[] interval : intervals) {

            int start = interval[0];
            int end = interval[1];

            if (newEnd < start) {
                if (!isInserted) {
                    result.addLast(new int[]{newStart, newEnd});
                    isInserted = true;
                }
                result.add(interval);
            } else if (newStart > end) {
                result.add(interval);
            } else {
                newStart = Math.min(newStart, start);
                newEnd = Math.max(newEnd, end);
            }
        }

        if (!isInserted)
            result.addLast(new int[]{newStart, newEnd});

        return result.toArray(new int[result.size()][]);
    }
}

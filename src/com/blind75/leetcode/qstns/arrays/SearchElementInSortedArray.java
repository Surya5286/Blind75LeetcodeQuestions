package com.blind75.leetcode.qstns.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchElementInSortedArray {

    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6));
        int target = 3;

        // Brute Force Approach [Linear Search] - O[N]
        System.out.println(findIndexOfTargetUsingBruteForceAppraoch(ls, target));

        // Optimal Approach [Binary Search] - O[LogN]
        System.out.println(findIndexOfTargetUsingOptimalAppraoch(ls, target));
    }

    private static int findIndexOfTargetUsingBruteForceAppraoch(List<Integer> list, int target) {

        for (int i = 0; i < list.size(); i++) {
            if (target == list.get(i)) return i;
        }

        return -1;
    }

    private static int findIndexOfTargetUsingOptimalAppraoch(List<Integer> list, int target) {

        int low = 0, high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (list.get(mid) == target) return mid;

            if (list.get(low) <= list.get(mid)) {

                if (list.get(low) <= target && target <= list.get(mid)) {

                    // element exists
                    high = mid - 1;

                } else {

                    // element doesn't exists
                    low = mid + 1;
                }

            } else {

                if (list.get(mid) <= target && target <= list.get(high)) {

                    // element exists
                    low = mid + 1;

                } else {

                    //  element doesn't exists
                    high = mid - 1;
                }

            }
        }
        return -1;
    }
}

package com.blind75.leetcode.qstns.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class TwoSum {

    public static void main(String[] args) {

        var log = Logger.getLogger(TwoSum.class.getName());

        int[] arr = {-1, -2, -3, -4, -5};
        int target = -8;

//        int[] arr = {1,3,5,2,6,8};
//        int target = 13;

        // Brute Force Approach.
        log.info(Arrays.toString(twoSumUsingBruteForceApproach(arr, target)));
        log.info(Arrays.toString(twoSumUsingBruteForceUpdatedApproach(arr, target)));

        // Better Approach Using Two Pointer Technique
        log.info(Arrays.toString(twoSumUsingTwoPointerApproach(arr, target)));

        /*
        * Location of the elements isn't a consideration
        * Optimal[Best] Approach Using Two Pointer and Sorting Technique
        * */
        log.info(twoSumUsingTwoPointerUsingSortingApproach(arr, target));

        // Optimal[Best] Approach Using Hashing Technique
        log.info(Arrays.toString(twoSumUsingHashingApproach(arr, target)));
    }


    private static int[] twoSumUsingHashingApproach(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int difference = target - arr[i];
            if (map.containsKey(difference)) {
                return new int[] { Math.min(i, map.get(difference)), Math.max(i, map.get(difference))};
            } else {
                map.put(arr[i], i);
            }
        }

        return new int[] {-1, -1};
    }

    private static int[] twoSumUsingBruteForceApproach(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                if (target == arr[i] + arr[j]) return new int[]{i, j};
            }
        }

        return new int[]{-1, -1};
    }

    private static int[] twoSumUsingBruteForceUpdatedApproach(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (target == arr[i] + arr[j]) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    private static int[] twoSumUsingTwoPointerApproach(int[] arr, int target) {

        int start = arr[0], end = arr[arr.length - 1], min = 0, max = arr.length - 1;
        while (min < max) {

            if (start + end == target) return new int[]{min, max};
            else if (start + end > target) {
                if (start < 0 && end < 0) {
                    min++;
                    start = arr[min];
                } else {
                    max--;
                    end = arr[max];
                }
            } else {
                if (start < 0 && end < 0) {
                    max--;
                    end = arr[max];
                } else {
                    min++;
                    start = arr[min];
                }
            }
        }

        return new int[]{-1, -1};
    }


    private static String twoSumUsingTwoPointerUsingSortingApproach(int[] numArray, int target) {
        int[] arr = numArray.clone();
        Arrays.sort(arr);
        int start = arr[0], end = arr[arr.length - 1];
        while (start <  end) {
            if (start + end == target) return "YES";
            else if (start + end > target) {
                end--;
            } else if (start + end < target) {
                start++ ;
            }
        }
        return "NO";
    }
}

package com.blind75.leetcode.qstns.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        int len = arr.length;
        int[][] dp = new int[len][len + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }


        // Brute Force Appraoch - Recursion
        // Time Complexity :  O[2^N]
        // Space Complexity : O[N]
        System.out.println(getMaxLengthUsingBruteForceRecursionMethod(arr, 0, -1, len));

        // Better Appraoch - Memoization
        // Time Complexity :  O[N*N]
        // Space Complexity : O[N*N] + O[N]
        System.out.println(getMaxLengthUsingMemoization(arr, 0, -1, len, dp));

        // Best Appraoch - Algorithmic Intuition
        // Time Complexity :  O[N*N]
        // Space Complexity : O[N]
        System.out.println(getMaxLengthUsingBetterApproach2(arr));

        // Best and Optimal Approach - Binary Search
        // Time Complexity :  O[N * logN]
        // Space Complexity : O[N]
        System.out.println(getMaxLengthUsingBestNOptimalUsingBinarySearch(arr));

    }

    private static int getMaxLengthUsingBruteForceRecursionMethod(int[] arr, int index, int prevIndex, int arrLength) {

        if (index == arrLength) return 0;

        int notTake = getMaxLengthUsingBruteForceRecursionMethod(arr, index + 1, prevIndex, arrLength);

        int take = 0;

        if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
            take = 1 + getMaxLengthUsingBruteForceRecursionMethod(arr, index + 1, index, arrLength);
        }

        return Math.max(take, notTake);
    }


    private static int getMaxLengthUsingMemoization(int[] arr, int index, int prevIndex, int len, int[][] dp) {

        if (index == len) return 0;

        if (dp[index][prevIndex + 1] != -1) return dp[index][prevIndex + 1];

        int notTake = getMaxLengthUsingMemoization(arr, index + 1, prevIndex, len, dp);

        int take = 0;

        if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
            take = 1 + getMaxLengthUsingMemoization(arr, index + 1, index, len, dp);
        }

        dp[index][prevIndex + 1] = Math.max(take, notTake);

        return dp[index][prevIndex + 1];
    }


    private static int getMaxLengthUsingBetterApproach2(int[] arr) {

        int max = Integer.MIN_VALUE;

        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        for (int index = 0; index < arr.length; index++) {
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                if (arr[index] > arr[prevIndex])
                    dp[index] = Math.max(dp[index], 1 + dp[prevIndex]);
            }
            max = Math.max(max, dp[index]);
        }
        return max;
    }

    private static int getMaxLengthUsingBestNOptimalUsingBinarySearch(int[] arr) {

        List<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);

        for (int i : arr) {
            if (i > ans.getLast()) { // ans.get(ans.size() - 1) = ans.getLast() | Since Jav 21
                ans.add(i);
            } else {
                int low = Collections.binarySearch(ans, i);

                if (low < 0)
                    low = -(low + 1);

                ans.set(low, i);
            }
        }

        // Print LIS Elements
        printLISElements(ans);

        System.out.println();
        return ans.size();
    }

    private static void printLISElements(List<Integer> ans) {
        ans.forEach(LongestIncreasingSubsequence::printList);
    }

    private static void printList(Integer integer) {
        System.out.print(integer + " ");
    }
}

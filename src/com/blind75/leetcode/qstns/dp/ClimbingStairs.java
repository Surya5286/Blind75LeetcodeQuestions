package com.blind75.leetcode.qstns.dp;

import java.util.Arrays;

public class ClimbingStairs {

    public static void main(String[] args) {

        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // Recursion Approach
        // Time Complexity : 0[2^N] -- Space Complexity : O[N]
        System.out.println(climbingStairsUsingRecursion(n));

        // Memoization Approach
        // Time Complexity : 0[N] -- Space Complexity : O[N]
        System.out.println(climbingStairsUsingMemoizationApproach(n, dp));

        // Tabulation Approach
        // Time Complexity : 0[N] -- Space Complexity : O[N]
        System.out.println(climbingStairsUsingTabulationApproach(n, dp));

        // Space Optimization Approach
        // Time Complexity : 0[N] -- Space Complexity : O[1]
        System.out.println(climbingStairsUsingSpaceOptimizationApproach(n));
    }

    private static int climbingStairsUsingRecursion(int n) {

        // If in case of Fibonacci - starting value would be "0" - Hence return statement would be "return n"
        if (n <= 1) return 1;

        return climbingStairsUsingRecursion(n - 1) + climbingStairsUsingRecursion(n - 2);
    }


    private static int climbingStairsUsingMemoizationApproach(int n, int[] dp) {

        // If in case of Fibonacci - starting value would be "0" - Hence return statement would be "return n"
        if (n <= 1) return 1;

        if (dp[n] != -1) return dp[n];
        return climbingStairsUsingMemoizationApproach(n - 1, dp) + climbingStairsUsingMemoizationApproach(n - 2, dp);

    }

    private static int climbingStairsUsingTabulationApproach(int n, int[] dp) {

        // If in case of Fibonacci - starting value would be "0" - Hence starting Index will be "0" but in here it would be "1"
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    private static int climbingStairsUsingSpaceOptimizationApproach(int n) {

        // If in case of Fibonacci - starting value would be "0" - Hence starting Index will be "0" but in here it would be "1"
        int prev2 = 1, prev = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev + prev2;

            prev2 = prev;
            prev = curr;

        }
        return prev;
    }
}

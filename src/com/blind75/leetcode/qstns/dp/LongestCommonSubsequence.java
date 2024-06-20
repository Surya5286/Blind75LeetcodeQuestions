package com.blind75.leetcode.qstns.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        var str1 = "surya";
        var str2 = "kalyan";

        // dp array - input for Memoization Strategy
        int[][] dp = new int[str1.length()][str2.length()];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        /*
         Brute Force Appraoch - Recursion Strategy
         Time Complexity :  O[2^N * 2^M]
         Space Complexity : O[N+M]
        */
        System.out.println(getMaxLengthOfLCSUsingRecursion(str1, str2, str1.length() - 1, str2.length() - 1));

        /*
         Better Appraoch - Memoization Strategy
         Time Complexity :  O[N * M]
         Space Complexity : O[N * M] + O[N+M]
        */
        System.out.println(getMaxLengthOfLCSUsingMemoization(str1, str2, str1.length() - 1, str2.length() - 1, dp));

        /*
         Best Appraoch - Tabulation Strategy
         Time Complexity :  O[N * M]
         Space Complexity : O[N * M]
        */
        System.out.println(getMaxLengthOfLCSUsingTabulation(str1, str2, str1.length(), str2.length()));

        /*
         Best & Optimal Appraoch - Space Optimization Strategy
         Time Complexity :  O[N * M]
         Space Complexity : O[M]
        */
        System.out.println(getMaxLengthOfLCSUsingSpaceOptimization(str1, str2));

    }

    private static int getMaxLengthOfLCSUsingRecursion(String str1, String str2, int ind1, int ind2) {

        if (ind1 < 0 || ind2 < 0) return 0;

        if (str1.charAt(ind1) == str2.charAt(ind2))
            return 1 + getMaxLengthOfLCSUsingRecursion(str1, str2, ind1 - 1, ind2 - 1);

        return Math.max(getMaxLengthOfLCSUsingRecursion(str1, str2, ind1 - 1, ind2),
                getMaxLengthOfLCSUsingRecursion(str1, str2, ind1, ind2 - 1));
    }

    private static int getMaxLengthOfLCSUsingMemoization(String str1, String str2, int ind1, int ind2, int[][] dp) {

        if (ind1 < 0 || ind2 < 0) return 0;

        if (dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if (str1.charAt(ind1) == str2.charAt(ind2))
            return 1 + getMaxLengthOfLCSUsingMemoization(str1, str2, ind1 - 1, ind2 - 1, dp);

        return Math.max(getMaxLengthOfLCSUsingMemoization(str1, str2, ind1 - 1, ind2, dp),
                getMaxLengthOfLCSUsingMemoization(str1, str2, ind1, ind2 - 1, dp));
    }

    private static int getMaxLengthOfLCSUsingTabulation(String str1, String str2, int l1, int l2) {

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        for (int i = 0; i <= l1; i++) dp[i][0] = 0;
        for (int i = 0; i <= l2; i++) dp[0][i] = 0;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[l1][l2];
    }

    private static int getMaxLengthOfLCSUsingSpaceOptimization(String str1, String str2) {

        int l1 = str1.length(), l2 = str2.length();
        int[] prev = new int[l2 + 1], curr = new int[l2 + 1];

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr.clone();
        }

        return prev[l2];
    }
}

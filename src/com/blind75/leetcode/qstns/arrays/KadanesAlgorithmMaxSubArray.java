package com.blind75.leetcode.qstns.arrays;

import java.util.Arrays;

public class KadanesAlgorithmMaxSubArray {

    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4, -2, 9};

        // BruteForce Approach - TimeComplexity : 0[N^3]
        System.out.println(getMaxSubArrayBruteForceApproach(arr));

        // Better Appraoch - TimeComplexity : 0[N^2]
        System.out.println(getMaxSubArrayBetterApproach(arr));

        // Optimal/Best Appraoch - TimeComplexity : 0[N]
        System.out.println(getMaxSubArrayUsingKadanesAlgoApproach(arr));

        // Optimal/Best Appraoch - TimeComplexity : 0[N]
        System.out.println(Arrays.toString(getMaxSubArrayValueIndexRangesUsingKadaneAlgoApproach(arr)));
    }

    private static int getMaxSubArrayBruteForceApproach(int[] arr) {

        int maxSumValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                maxSumValue = Math.max(maxSumValue, sum);
            }
        }
        return maxSumValue;
    }

    private static int getMaxSubArrayBetterApproach(int[] arr) {

        int maxSumValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                maxSumValue = Math.max(maxSumValue, sum);
            }
        }
        return maxSumValue;
    }

    private static int getMaxSubArrayUsingKadanesAlgoApproach(int[] arr) {

        int sum = arr[0];
        int maxSumValue = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
            }
            maxSumValue = Math.max(maxSumValue, sum);
        }
        return maxSumValue;
    }

    private static int[] getMaxSubArrayValueIndexRangesUsingKadaneAlgoApproach(int[] arr) {

        int sum = 0, maxSumValue = Integer.MIN_VALUE, start = 0, startIndex = -1, endIndex = -1;

        for (int i = 0; i < arr.length; i++) {

            if (sum == 0) start = i;
            sum += arr[i];

            if (sum > maxSumValue) {
                maxSumValue = sum;
                startIndex = start;
                endIndex = i;
            }

            if(sum < 0)  sum = 0;
        }

        return new int[]{maxSumValue, startIndex, endIndex};
    }
}

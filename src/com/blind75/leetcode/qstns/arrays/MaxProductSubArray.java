package com.blind75.leetcode.qstns.arrays;

public class MaxProductSubArray {

    public static void main(String[] args) {

        int[] arr = {-1, -3, 10, 0, 60};

        // Brute Force Approach - O[N^3]
        System.out.println(getMaxProductSubArrayUsingBruteForceAppraoch(arr));

        // Better Approach - O[N^2]
        System.out.println(getMaxProductSubArrayUsingBetterAppraoch(arr));

        // Best (Optimal) Approach - O[N] : Case 1 [Advisable]
        System.out.println(getMaxProductSubArrayUsingOptimalNIntuitiveAppraoch(arr));

        // Best (Optimal) Approach - O[N] : Case 2 [Kadane's Algorithm]
        System.out.println(getMaxProductSubArrayUsingOptimalKadaneAlgorithm(arr));
    }

    private static int getMaxProductSubArrayUsingBruteForceAppraoch(int[] arr) {

        int maxProdValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int prod = 1;
                for (int k = i; k <= j; k++) {
                    prod *= arr[k];
                }
                maxProdValue = Math.max(maxProdValue, prod);
            }
        }

        return maxProdValue;
    }

    private static int getMaxProductSubArrayUsingBetterAppraoch(int[] arr) {
        int maxProdValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int prod = 1;
            for (int j = i; j < arr.length; j++) {
                prod *= arr[j];

                maxProdValue = Math.max(maxProdValue, prod);
            }
        }
        return maxProdValue;
    }

    private static int getMaxProductSubArrayUsingOptimalNIntuitiveAppraoch(int[] arr) {
        int maxProdValue = Integer.MIN_VALUE, prefixProd = 1, suffixProd = 1;

        for (int i = 0; i < arr.length; i++) {

            prefixProd = prefixProd * arr[i];
            suffixProd = suffixProd * arr[arr.length - 1 - i];

            maxProdValue = Math.max(maxProdValue, Math.max(prefixProd, suffixProd));
            if (suffixProd == 0) suffixProd = 1;
            if (prefixProd == 0) prefixProd = 1;
        }

        return maxProdValue;
    }


    private static int getMaxProductSubArrayUsingOptimalKadaneAlgorithm(int[] arr) {
        int maxProdValue = arr[0], minProd = arr[0], maxProd = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxProd = Math.max(arr[i], Math.max(minProd * arr[i], maxProd * arr[i]));
            minProd = Math.min(arr[i], Math.min(minProd * arr[i], maxProd * arr[i]));

            maxProdValue = Math.max(maxProdValue, maxProd);
        }
        return maxProdValue;
    }

}

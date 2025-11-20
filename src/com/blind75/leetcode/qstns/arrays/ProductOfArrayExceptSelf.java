package com.blind75.leetcode.qstns.arrays;

import java.util.Arrays;
import java.util.logging.Logger;

public class ProductOfArrayExceptSelf {

    private static final Logger logger = Logger.getLogger(ProductOfArrayExceptSelf.class.getName());

    public static
    void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] resultArray = getProductArrayUsingBruteForceApproach(arr);
        logger.info(() -> "Product Array is : " + Arrays.toString(resultArray));

        int[] resultArrayBetter = getProductArrayUsingBetterApproach(arr);
        logger.info(() -> "Product Array using Better Approach is : " + Arrays.toString(resultArrayBetter));

        int[] resultArrayOptimal = getProductArrayUsingOptimalApproach(arr);
        logger.info(() -> "Product Array using Optimal Approach is : " + Arrays.toString(resultArrayOptimal));
    }

    private static int[] getProductArrayUsingBruteForceApproach(int[] arr) {

        int[] result = new int[arr.length];
        Arrays.fill(result, 1);

        for (int i = 0; i<arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                result[i] = result[i] * arr[j];
            }
        }

        return result;
    }

    private static int[] getProductArrayUsingBetterApproach(int[] arr) {

        int[] prefix = new int[arr.length];
        int[] suffix = new int[arr.length];
        int[] result = new int[arr.length];

        prefix[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] * arr[i - 1];
        }

        suffix[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i + 1];
        }

        for (int i = 0; i < arr.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    private static int[] getProductArrayUsingOptimalApproach(int[] arr) {
        int[] result = new int[arr.length];
        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < arr.length; i++) {
            result[i] = prefix;
            prefix = prefix * arr[i];
        }

        for (int i = arr.length-2; i >= 0 ; i--) {
            suffix = suffix * arr[i + 1];
            result[i] = result[i] * suffix;

        }

        return result;
    }

}

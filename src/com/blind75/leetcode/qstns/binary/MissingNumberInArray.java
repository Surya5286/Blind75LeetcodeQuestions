package com.blind75.leetcode.qstns.binary;

import java.util.HashSet;
import java.util.Set;

public class MissingNumberInArray {

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 8, 9};

        // Better Approach
        // Time Complexity : O[N]  -- Space Complexity : O[N]
        System.out.println(getMissingElementFromArrayUsingBetterApproach(arr));

        // Optimal Approach
        // Time Complexity : O[N]  -- Space Complexity : O[1]
        System.out.println(getMissingElementFromArrayUsingOptimalApproach(arr));
    }

    private static int getMissingElementFromArrayUsingBetterApproach(int[] arr) {

        Set<Integer> set = new HashSet<>();

        for (int j : arr)
            set.add(j);

        for (int i = 0; i <= arr.length; i++)
            if (!set.contains(i)) return i;

        return -1;

    }

    private static int getMissingElementFromArrayUsingOptimalApproach(int[] arr) {

        int missingNumber = arr.length;

        for (int i = 0; i < arr.length; i++)
            missingNumber ^= arr[i] ^ i;

        return missingNumber;
    }
}

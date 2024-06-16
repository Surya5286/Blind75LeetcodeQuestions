package com.blind75.leetcode.qstns.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};

        //Brute Force Approach
        //Time Complexity: O[N^2] - Space Complexity: O[1]
        System.out.println(findArrayHasDuplicateElementsUsingBruteForceAppraoch(arr));

        //Better Approach
        //Time Complexity: O[N * logN] - Space Complexity: O[1]
        System.out.println(findArrayHasDuplicateElementsUsingBetterAppraoch(arr));

        //Best/Optimal Approach
        //Time Complexity: O[N] - Space Complexity: O[N]
        System.out.println(findArrayHasDuplicateElementsUsingBestAppraoch(arr));

        System.out.println(findArrayHasDuplicateElementsUsingBestAppraoch2(arr));
    }

    private static boolean findArrayHasDuplicateElementsUsingBruteForceAppraoch(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] == arr[j]) return true;
        }

        return false;
    }

    private static boolean findArrayHasDuplicateElementsUsingBetterAppraoch(int[] array) {

        int[] arr = array.clone();
        Arrays.sort(arr);

        for (int i = 1; i < array.length; i++)
            if (arr[i] == arr[i - 1]) return true;

        return false;
    }

    private static boolean findArrayHasDuplicateElementsUsingBestAppraoch(int[] arr) {

        Set<Integer> set = new HashSet<>();

        for (int j : arr) {
            if (set.contains(j)) return true;
            set.add(j);
        }
        return false;
    }

    private static boolean findArrayHasDuplicateElementsUsingBestAppraoch2(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int j : arr) set.add(j);

        return set.size() < arr.length;
    }
}

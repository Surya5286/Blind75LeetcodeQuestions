package com.blind75.leetcode.qstns.arrays;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        int[] arr = {-1, 0, 1, 2, -1, -4};

        // Brute Force Approach
        // Time Complexity : O[N^3 *  log ( no.of triplets)]  -- Space Complexity: 2 log ( no.of triplets)
        System.out.println(getTripletSumListISZeroUsingBruteForceApproach(arr));

        // Better Approach
        // Time Complexity : O[N^2 *  log ( no.of triplets)] -- Space Complexity: 2 log ( no.of triplets) + O[N]
        System.out.println(getTripletSumListISZeroUsingBetterApproach(arr));

        // Optimal/Best
        // Time Complexity : O[N^2 *  logN]  & Space Complexity: O[1]
        System.out.println(getTripletSumListISZeroUsingOptimalApproach(arr));
    }

    private static List<List<Integer>> getTripletSumListISZeroUsingBruteForceApproach(int[] arr) {

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (0 == arr[i] + arr[j] + arr[k]) {
                        List<Integer> temp = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k]));
                        temp.sort(null);
                        set.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    private static List<List<Integer>> getTripletSumListISZeroUsingBetterApproach(int[] arr) {
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            Set<Integer> integerSet = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                int k = -(arr[i] + arr[j]);
                if (integerSet.contains(k)) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(arr[i], arr[j], k));
                    Collections.sort(list);
                    set.add(list);
                }
                integerSet.add(arr[j]);
            }
        }
        return new ArrayList<>(set);
    }

    private static List<List<Integer>> getTripletSumListISZeroUsingOptimalApproach(int[] array) {

        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = array.clone();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {

            if (i != 0 && arr[i] == arr[i - 1]) continue;

            int j = i + 1, k = arr.length - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    ans.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;

                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k - 1]) k--;
                }

            }
        }

        return ans;
    }
}

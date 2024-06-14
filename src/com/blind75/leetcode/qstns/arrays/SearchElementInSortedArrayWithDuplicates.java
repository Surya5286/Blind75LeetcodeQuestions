package com.blind75.leetcode.qstns.arrays;

public class SearchElementInSortedArrayWithDuplicates {

    public static void main(String[] args) {
        int[] arr = {7, 8, 8, 8, 9, 1, 2, 3, 4, 5, 5, 5, 5, 6, 6, 6, 6};
        int target = 1;

        // Brute Force Approach - Linear Search : O[N]
        System.out.println(findElementInDuplicateSortedArrayUsingBruteForce(arr, target));

        // Best Approach - Binary Search : O[logN]
        System.out.println(findElementInDuplicateSortedArray(arr, target));

        // Optimal Approach - Binary Search : O[logN]
        System.out.println(findElementInDuplicateSortedArrayOptimalHandling(arr, target));
    }

    private static String findElementInDuplicateSortedArrayUsingBruteForce(int[] arr, int target) {

        for (int i : arr) if (arr[i] == target) return "YES";

        return "NO";
    }

    private static String findElementInDuplicateSortedArray(int[] arr, int target) {

        int low = 0, high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return "YES";

            if (arr[low] <= arr[mid]) {

                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {

                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return "NO";
    }


    private static String findElementInDuplicateSortedArrayOptimalHandling(int[] arr, int target) {

        int low = 0, high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return "YES";

            if(arr[low] == arr[mid] && arr[mid] == arr[high]) {
                high --; low ++;
                continue;
            }

            if (arr[low] <= arr[mid]) {

                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {

                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return "NO";
    }
}

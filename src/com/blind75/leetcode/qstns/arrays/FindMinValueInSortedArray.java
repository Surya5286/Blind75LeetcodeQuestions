package com.blind75.leetcode.qstns.arrays;

public class FindMinValueInSortedArray {

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 5, 5, 6, 6, 6, 6, 6};

        // Brute Force Approach - Linear Search : O[N]
        System.out.println(findMinValueUsingBruteForceApproach(arr));

        // Best Approach - Binary Search : O[LogN]
        System.out.println(findMinValueUsingBinarySearchApproach(arr));

        // Best and further Optimal Approach - Binary Search : O[LogN]
        System.out.println(findMinValueUsingBinarySearchFurtherOptimizedApproach(arr));
    }

    private static int findMinValueUsingBruteForceApproach(int[] arr) {
        int ans = Integer.MAX_VALUE;

        for (int j : arr)
            ans = Math.min(ans, j);

        return ans;
    }

    private static int findMinValueUsingBinarySearchApproach(int[] arr) {

        int ans = Integer.MAX_VALUE, low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }

    private static int findMinValueUsingBinarySearchFurtherOptimizedApproach(int[] arr) {

        int ans = Integer.MAX_VALUE, low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }

            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}

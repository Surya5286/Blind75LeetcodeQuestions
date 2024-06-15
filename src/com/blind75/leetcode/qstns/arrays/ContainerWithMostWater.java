package com.blind75.leetcode.qstns.arrays;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7}; // Output: 49

       /*
          Optimal Approach : Extract Max Units Of Water Container stores.
          Time Complexity: O[N]
          Space Complexity: O[1]
        */
        System.out.println(getMaxUnitsOfWaterContainerStore(arr));

    }

    private static int getMaxUnitsOfWaterContainerStore(int[] arr) {

        int ans = Integer.MIN_VALUE, left = 0, right = arr.length - 1;

        while (left < right) {
            int minHeight = Math.min(arr[left], arr[right]);
            ans = Math.max(ans, minHeight * (right - left));

            if (arr[left] < arr[right]) left++;
            else right--;
        }
        return ans;
    }
}

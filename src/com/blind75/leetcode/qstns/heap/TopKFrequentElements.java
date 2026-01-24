package com.blind75.leetcode.qstns.heap;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequentElementsUsingMinHeapBetterApproach(nums, k);
        System.out.println("Top " + k + " frequent elements: " + Arrays.toString(result)); // Output: [1, 2]

        int[] nums2 = {4, 1, -1, 2, -1, 2, 3};
        int k2 = 2;
        int[] result2 = topKFrequentElementsUsingMinHeapBetterApproach(nums2, k2);
        System.out.println("Top " + k2 + " frequent elements: " + Arrays.toString(result2)); // Output: [ -1, 2]
    }

    /*
        Complexity (what to say)
            Building frequency map: O(n)
            Heap operations: O(m log k) where m = #unique elements
            Time Complexity :- O(n + m log k) or O(n log k) in worst case when all elements are unique
            Space Complexity :- O(m + k) ~ O(m) for frequency map and O(k) for heap
    */
    private static int[] topKFrequentElementsUsingMinHeapBetterApproach(int[] numArray, int k) {

        // Edge cases
        if (numArray == null || numArray.length == 0 || k <= 0)
            return new int[0];

        if (k == numArray.length)
            return numArray;

        // Frequency map to count occurrences of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>((int) (numArray.length / 0.75f) + 1); // Initial capacity to avoid rehashing

        // Insert the Array elements into the frequency map with their frequencies
        for (int num : numArray)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        // Min-heap to keep track of top k frequent elements
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a,b) -> Integer.compare(a.getValue(),b.getValue())  // (a,b) -> a.getValue() - b.getValue()
        );

        // Build the min-heap with top k frequent elements
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {

            minHeap.add(entry);

            // Maintain the size of the heap to be at most k
            if(minHeap.size() > k)
                minHeap.poll();
        }

        int capacity = Math.min(k, frequencyMap.size());
        int[] result = new int[capacity];

        for (int i = capacity-1 ; i >= 0 ; i--)
            result[i] = minHeap.poll().getKey();

        return result;
    }
}

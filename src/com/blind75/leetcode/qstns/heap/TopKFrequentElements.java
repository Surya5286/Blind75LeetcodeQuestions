package com.blind75.leetcode.qstns.heap;

import java.util.*;

/*
    Heap is usually better when k is small;
    bucket sort is theoretically linear but can cost more memory and object allocations.

    Heap Approach is recommended.
*/

public class TopKFrequentElements {

    public static void main(String[] args) {

        int[] numArray = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequentElementsUsingMinHeapBetterApproach(numArray, k);
        System.out.println("Top " + k + " frequent elements (Min Heap): " + Arrays.toString(result)); // Output: [1, 2]

        int[] numArray2 = {4, 1, -1, 2, -1, 2, 3};
        int k2 = 2;
        int[] result2 = topKFrequentElementsUsingMinHeapBetterApproach(numArray2, k2);
        System.out.println("Top " + k2 + " frequent elements (Min Heap): " + Arrays.toString(result2)); // Output: [ -1, 2]

        System.out.println("--------------------------------------------------");
        System.out.println("Optimal Approach using Bucket Sort");
        System.out.println("--------------------------------------------------");

        // Another Approach
        int[] result3 = topKFrequentElementsUsingBucketSortOptimalApproach(numArray, k);
        System.out.println("Top " + k + " frequent elements (BucketSort): " + Arrays.toString(result3)); // Output: [1, 2]

        int[] result4 = topKFrequentElementsUsingBucketSortOptimalApproach(numArray2, k2);
        System.out.println("Top " + k2 + " frequent elements (BucketSort): " + Arrays.toString(result4)); // Output: [ -1, 2]
    }

    /*
        Complexity (what to say)
            Building frequency map: O(n)
            Heap operations: O(m log k) where m = #unique elements
            Time = O(n + m log k) where m <= n
                    Worst case m = n → O(n log k)
                    If k ≈ n → O(n log n)
            Space Complexity :- O(m + k) ~ O(m) for frequency map and O(k) for heap
    */
    private static int[] topKFrequentElementsUsingMinHeapBetterApproach(int[] numArray, int k) {

        // Edge cases
        if (numArray == null || numArray.length == 0 || k <= 0)
            return new int[0];

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

    /*
       Complexity (what to say)
            Building frequency map: O(n)
            Bucket sort operations: O(n)
            Time Complexity :- O(n)
            Space Complexity :- O(n) for frequency map and buckets
   */
    @SuppressWarnings("unchecked")
    private static int[] topKFrequentElementsUsingBucketSortOptimalApproach(int[] numArray, int k) {

        // Edge cases
        if (numArray == null || numArray.length == 0 || k <= 0)
            return new int[0];

        Map<Integer, Integer> frequencyMap = new HashMap<>((int) (numArray.length / 0.75f) + 1); // Initial capacity to avoid rehashing

        for (int num : numArray)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        // Create buckets where index represents frequency
        List<Integer>[] buckets = new List[numArray.length + 1];

        // Fill the buckets
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (buckets[frequency] == null)
                buckets[frequency] = new ArrayList<>();
            buckets[frequency].add(entry.getKey());
        }

        int capacity = Math.min(k, frequencyMap.size());
        int[] result = new int[capacity];

        int resultIndex = 0;

        for (int i = buckets.length - 1; i >=0 && resultIndex < k; i--) {
            if(buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[resultIndex++] = num;
                    if (resultIndex == k)
                        break;
                }
            }
        }

        return result;
    }
}

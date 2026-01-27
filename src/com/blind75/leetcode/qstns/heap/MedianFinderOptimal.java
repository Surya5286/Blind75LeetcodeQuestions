package com.blind75.leetcode.qstns.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinderOptimal {

    /*
        Implement below methods :-
        1. MedianFinder() -> constructor
        2. addNum(int num) -> void : Time Complexity: O(log n) - for adding to heaps
        3. findMedian() -> double : Time Complexity: O(1)

        Maintain two heaps:
        1. Max-Heap (low) to store the lower half of numbers
        - peek() gives the maximum of the lower half

        2. Min-Heap (high) to store the upper half of numbers
        - peek() gives the minimum of the upper half
    */

    private final PriorityQueue<Integer> low; // Max-Heap
    private final PriorityQueue<Integer> high; // Min-Heap

    public MedianFinderOptimal() {
        low = new PriorityQueue<>(Collections.reverseOrder()); // new PriorityQueue<>((a, b) -> b - a);
        high = new PriorityQueue<>();
    }

    /*
        add number into the heaps and balance them.
        Time Complexity: O(log n)
    */
    public void addNum(int num) {
        low.add(num);
        high.add(low.poll());

        // Maintain the low (max-heap) size less than or equal to high (min-heap) size
        if (low.size() < high.size()) {
            low.add(high.poll());
        }
    }

    /*
        Returns the median of all elements so far.
        Time Complexity: O(1)
    */
    public double findMedian() {
        if (low.size() > high.size()) {
            return low.peek();
        } else {
            return (low.peek() + high.peek()) / 2.0;
        }
    }
}

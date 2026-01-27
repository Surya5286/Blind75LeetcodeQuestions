package com.blind75.leetcode.qstns.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianFinder {

    /*
        Implement below methods :-
        1. MedianFinder() -> constructor
        2. addNum(int num) -> void : Time Complexity: O(1)
        3. findMedian() -> double : Time Complexity: O(n log n)
    */

    private final List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    /*
        Adds a number into the data structure.
        Time Complexity: O(1)
    */
    public void addNum(int num) {
        list.add(num);
    }


    /*
        Returns the median of all elements so far.
        Time Complexity: O(n log n)
    */
    public double findMedian() {

        Collections.sort(list);
        int size = list.size();

        if (size % 2 == 0)
            return (list.get(size / 2) + list.get((size / 2) - 1)) / 2.0;
        else
            return list.get(size / 2);
    }
}

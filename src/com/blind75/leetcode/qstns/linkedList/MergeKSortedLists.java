package com.blind75.leetcode.qstns.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    /*
          Input: [
            1 -> 4 -> 5,
            1 -> 3 -> 4,
            2 -> 6
        ]
        Output: [1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6]
    */

    // Brute Force Approach
    // Time Complexity : O[N] * O[(K * K+1)/2] -- Space Complexity : O[1]
    public ListNode mergeKListsBruteForceAppraoch(ListNode[] lists) {

        ListNode head = lists[0];

        for (int i = 1; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    // Better Approach
    // The concept of interval usage introduces - Divide and Conquer Strategy
    // Time Complexity : O[N] * O[log K] -- Space Complexity : O[1]
    public ListNode mergeKLists(ListNode[] lists) {

        int n = lists.length;
        int interval = 1;

        while (interval < n) { // O[log K]

            for (int i = 0; i + interval < n; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]); //O[N]
            }

            interval = interval * 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode temp = new ListNode(-1);
        ListNode newNode = temp;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }

        temp.next = (list1 != null) ? list1 : list2;

        return newNode.next;
    }


    // Best Approach
    // Use the Priority Queue [Data Structure implemented on - MIN_HEAP Strategy]
    // Time Complexity : O[ k * log K] + O[ N * k * log K]
    // Space Complexity : O[K]
    public ListNode mergeKListsUsingPriorityQueue(ListNode[] lists) {

        int length = lists.length;
        ListNode head = null, last = null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        return o1.val - o2.val;
                    }
                }
        );

        // Push the head nodes of all the k lists in 'pq'
        for (int i = 0; i < length; i++) {
            if (lists[i] != null)
                pq.add(lists[i]);
        }

        while (!pq.isEmpty()) {
            ListNode top = pq.peek(); // Fetch the top element (1st List on Top of PQ)
            pq.remove();

            // Extract and Map each element from 'top' Node to 'pq'
            if (top.next != null)
                pq.add(top.next);

            if (head == null) {
                head = top;
                last = top;
            } else {
                last.next = top;
                last = top;
            }
        }

        return head;
    }

    // Function to print the singly linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("END");
    }
}

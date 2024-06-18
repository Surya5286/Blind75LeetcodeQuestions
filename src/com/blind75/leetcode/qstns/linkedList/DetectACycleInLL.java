package com.blind75.leetcode.qstns.linkedList;

import java.util.List;

public class DetectACycleInLL {

    // Method to detect weather a Cycle is present or not.
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }

    // Method to detect length of a Cycle if present.
    public int cycleLength(ListNode head) {

        int length = 0;
        if (head == null || head.next == null) return length;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if( slow == fast) {
                ListNode temp = slow;
                do{
                    temp = temp.next;
                    length++;
                } while (temp != slow);
            }
        }
        return length;
    }

    // Method to detect the Node where exactly the Cycle starts.
    public ListNode detectCycleStartNode(ListNode head) {
        int length = 0;
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if( slow == fast) {
                length = cycleLength(slow); // If Cycle exists -  get the length of cycle.
                break;
            }
        }

        // if length is not present [No cycle] -  return null

        if(length == 0)
            return null;

        // Initiate 2 pointer, First and Second.
        // Run the second Node till length of the cycle.
        // Now iterate both first and second, where they meets returns the required Node (The Cycle started position)

        ListNode first = head, second = head;
        while (length > 0) {
            second = second.next;
            length--;
        }

        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return second;
    }
}


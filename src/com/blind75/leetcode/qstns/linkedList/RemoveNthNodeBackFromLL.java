package com.blind75.leetcode.qstns.linkedList;

public class RemoveNthNodeBackFromLL {

    // Time Complexity : O[2N] -- Space Complexity : O[N]
    public ListNode removeNthFromEndBruteForce(ListNode head, int n) {

        int len = 0;
        ListNode temp = head;

        ListNode slow = new ListNode(-1);
        slow.next = head;

        ListNode fast = slow;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        if (len == n) {
            slow.next = slow.next.next;
            return fast.next;
        }

        temp = head;
        int res = len - n;

        while (temp != null) {
            res--;
            if (res == 0) break;
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = head;

        ListNode slow = new ListNode(-1);
        slow.next = head;

        ListNode fast = slow;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return temp;
    }
}

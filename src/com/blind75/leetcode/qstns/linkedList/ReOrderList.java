package com.blind75.leetcode.qstns.linkedList;

import java.util.List;

public class ReOrderList {

    public ListNode reorderList(ListNode head) {

        ListNode dummy = head;

        ListNode mid = getMiddleNode(head);
        ListNode head2 = getReversedList(mid);

        mid.next = null;

        head = reorderList(head, head2);

        return head;

    }

    private ListNode getMiddleNode(ListNode head) {

        if(head == null || head.next == null)   return head;
        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    private ListNode getReversedList(ListNode head) {
        ListNode curr = head, prev = null, next = head.next;

        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;

            if(next != null)    next = next.next;
        }
        return prev;
    }

    private ListNode reorderList(ListNode head, ListNode head2) {

        ListNode originalHead = head;

        while (head != null && head2 != null) {
            ListNode temp1 = head.next, temp2 = head2.next;
            head.next = head2;
            head2.next = temp1;

            head = temp1;
            head2 = temp2;
        }

        return originalHead;
    }


}

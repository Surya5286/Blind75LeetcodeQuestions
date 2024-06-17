package com.blind75.leetcode.qstns.linkedList;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        if( head == null)   return head;

        ListNode curr = head, prev = null, next = curr.next;

        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) next = next.next;
        }

        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

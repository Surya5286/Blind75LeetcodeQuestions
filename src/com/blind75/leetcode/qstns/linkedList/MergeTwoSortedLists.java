package com.blind75.leetcode.qstns.linkedList;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode newHead = new ListNode(-1);
        ListNode curr = newHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            } else {
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            }
        }

        curr.next = (list1 != null) ? list1 : list2;
        return newHead.next;

    }
}

package com.jinku.learn.leetcode;

/**
 * 合并两个有序链表
 */
public class Num021 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = null;
        ListNode pre = null;

        while (l1 != null || l2 != null) {
            ListNode cur;

            if (l2 == null || (l1 != null && l1.val <= l2.val)) {
                cur = l1;
                l1 = l1.next;
            } else {
                cur = l2;
                l2 = l2.next;
            }

            if (pre != null) {
                pre.next = cur;
            }

            if (first == null) {
                first = cur;
            }
            pre = cur;
        }
        return first;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

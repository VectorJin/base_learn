package com.jinku.learn.leetcode;

/**
 * 反转链表
 */
public class Num206 {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;

            if (next == null) {
                return head;
            }
            head = next;
        }
        return null;
    }

    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return pre;
    }



    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

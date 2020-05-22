package com.jinku.learn.leetcode;

/**
 * K 个一组翻转链表
 */
public class Num025 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode ans = null;

        ListNode current = head;
        ListNode preLast = null;

        while (current != null && current.next != null) {

            if (!needReverse(current, k)) {
                return ans;
            }
            int i = 1;
            ListNode tmpCurr = current;
            ListNode tmpFirst = tmpCurr;
            ListNode tmpLast = tmpCurr;

            while (i < k) {
                ListNode tmpNext = tmpCurr.next;
                ListNode tmNextNext = tmpNext.next;

                tmpNext.next = tmpFirst;
                tmpCurr.next = tmNextNext;
                current = tmNextNext;

                tmpFirst = tmpNext;
                tmpLast = tmpCurr;
                i++;
            }
            if (preLast != null) {
                preLast.next = tmpFirst;
            }
            preLast = tmpLast;
            if (ans == null) {
                ans = tmpFirst;
            }
        }
        return ans;
    }

    public boolean needReverse(ListNode node, int k) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count >= k;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

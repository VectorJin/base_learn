package com.jinku.learn.leetcode;

/**
 * 链表中倒数第k个节点
 */
public class Offer22 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 快慢指针解法
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        // 快指针先走k步
        ListNode fast = head;
        while (k > 1) {
            fast = fast.next;
            k--;
            if (fast == null) {// k超出范围
                fast = head;
            }
        }

        // 快慢指针同时走
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

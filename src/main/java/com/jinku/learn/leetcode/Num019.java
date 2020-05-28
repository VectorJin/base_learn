package com.jinku.learn.leetcode;

/**
 * 删除链表的倒数第N个节点
 */
public class Num019 {

    ListNode newHead;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        helper(head, head, head, n);
        return newHead;
    }

    public int helper(ListNode head, ListNode pre, ListNode curr, int n) {
        if (curr.next == null) {
            // 当前最后一个节点
            if (n == 1) {
                if (curr == head) {
                    newHead = null;
                } else {
                    newHead = head;
                    pre.next = null;
                }
            }
            return 1;
        }
        int index = helper(head, curr, curr.next, n) + 1;
        if (index == n) {
            if (curr == head) {
                newHead = head.next;
            } else {
                newHead = head;
                pre.next = curr.next;
            }
        }
        return index;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        if (length == 1) {
            return null;
        }
        node = head;
        ListNode preNode = null;
        int index = length - n;
        for (int i = 1; i <= index; i++) {
            preNode = node;
            node = node.next;
        }
        if (node == head) {
            return head.next;
        }
        preNode.next = node.next;
        return head;
    }

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

package com.jinku.learn.leetcode;

/**
 * 奇偶链表
 */
public class Num328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        // 最后的节点
        ListNode tail = null;
        int count = 0;
        while (node != null) {
            tail = node;
            count++;
            node = node.next;
        }

        // 将偶节点放到最后
        ListNode pre = head;
        node = head;
        int index = 1;
        while (node != null && index <= count) {
            ListNode next = node.next;
            if (index % 2 == 0) {
                tail.next = node;
                tail = node;
                pre.next = node.next;
                node.next = null;
            }
            index++;
            pre = node;
            node = next;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

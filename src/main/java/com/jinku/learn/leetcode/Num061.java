package com.jinku.learn.leetcode;

/**
 * 旋转链表
 */
public class Num061 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 先计算链表长度
        ListNode node = head;
        int count = 0;
        ListNode last = node;// 最后的节点
        while (node != null) {
            count++;
            last = node;
            node = node.next;
        }

        if (count == 1) {
            return head;
        }
        // 计算拐点
        k = count - (k % count);

        if (count == k) {
            return head;
        }

        ListNode newHead = null;
        node = head;
        int index = 1;
        // 反转链表
        while (node != null) {
            if (index == k) {
                newHead = node.next;
                node.next = null;
                last.next = head;
                break;
            }
            node = node.next;
            index++;
        }

        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

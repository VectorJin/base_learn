package com.jinku.learn.leetcode;

/**
 * 排序链表
 */
public class Num148 {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return helper(head);
    }

    private static ListNode helper(ListNode head) {
        // 计算链表长度
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        if (count <= 1) {
            return head;
        }

        int mid = count / 2;
        // 拆分成两个链表
        ListNode node1 = head;
        ListNode node2 = null;

        node = head;
        int index = 1;
        while (node != null) {

            if (index == mid) {
                node2 = node.next;
                node.next = null;
                break;
            }

            index++;
            node = node.next;
        }

        ListNode sortedNode1 = helper(node1);
        ListNode sortedNode2 = helper(node2);

        // 合并两个有序的链表
        return mergeSortedNode(sortedNode1, sortedNode2);
    }

    private static ListNode mergeSortedNode(ListNode node1, ListNode node2) {
        ListNode head = null;
        ListNode curNode = null;
        ListNode preNode = null;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                curNode = node1;
                node1 = node1.next;
            } else {
                curNode = node2;
                node2 = node2.next;
            }

            if (preNode == null) {
                preNode = curNode;
            } else {
                preNode.next = curNode;
                preNode = curNode;
            }

            if (head == null) {
                head = curNode;
            }
        }

        while (node1 != null) {
            curNode.next = node1;
            curNode = node1;
            node1 = node1.next;
        }

        while (node2 != null) {
            curNode.next = node2;
            curNode = node2;
            node2 = node2.next;
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

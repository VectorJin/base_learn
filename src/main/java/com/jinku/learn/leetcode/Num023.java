package com.jinku.learn.leetcode;

import java.util.Arrays;

/**
 * 合并K个排序链表
 */
public class Num023 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode first = null;
        ListNode preNode = null;
        while (true) {
            // 判断循环是否结束
            boolean isOver = true;
            for (ListNode node : lists) {
                if (node != null) {
                    isOver = false;
                }
            }
            if (isOver) {
                break;
            }

            // 获取最小的值
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node != null) {
                    if (node.val < min) {
                        min = node.val;
                        minIndex = i;
                    }
                }
            }
            ListNode tmpNode = new ListNode(lists[minIndex].val);
            if (preNode != null) {
                preNode.next = tmpNode;
            }
            preNode = tmpNode;

            // 往右移位
            lists[minIndex] = lists[minIndex].next;
            if (first == null) {
                first = tmpNode;
            }
        }

        return first;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

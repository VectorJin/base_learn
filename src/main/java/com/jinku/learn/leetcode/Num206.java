package com.jinku.learn.leetcode;

import com.jinku.learn.interview.Algorithm;

/**
 * 反转链表
 */
public class Num206 {

    /**
     * 递归解法
     *
     * @param pre
     * @param node
     * @return
     */
    private ListNode helper(ListNode pre, ListNode node) {
        // 当前节点指针指向前一节点
        ListNode next = node.next;
        node.next = pre;
        if (next == null) {
            // 当前为最后一个节点
            return node;
        }
        // 继续访问下一个节点
        return helper(node, node.next);
    }

    /**
     * 迭代解法
     *
     * @return
     */
    private ListNode iterate(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;

            if (next == null) {
                return node;
            }
            node = next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

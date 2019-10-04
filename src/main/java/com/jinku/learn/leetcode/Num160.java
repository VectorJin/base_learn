package com.jinku.learn.leetcode;

/**
 * 相交链表
 */
public class Num160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        boolean hasSwitched = false;

        while (true) {

            if (nodeA != null && nodeA == nodeB) {
                return nodeA;
            }

            if (nodeA == null) {
                if (hasSwitched) {
                    return null;
                }
                nodeA = headB;
                hasSwitched = true;
            } else {
                nodeA = nodeA.next;
            }

            if (nodeB == null) {
                nodeB = headA;
            } else {
                nodeB = nodeB.next;
            }
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

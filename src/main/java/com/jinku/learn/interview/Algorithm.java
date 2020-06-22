package com.jinku.learn.interview;

/**
 * 面试算法合集
 */
public class Algorithm {

    /**
     * 探探算法：二分查找
     */
    @org.junit.Test
    public void binarySearch() {
        int[] sorted = new int[]{1, 2, 5, 6, 8, 9};
        System.out.println(helper(5, sorted, 0, sorted.length - 1));
    }

    private int helper(int value, int[] sorted, int left, int right) {
        int mid = (right - left) / 2 + left;
        if (value == sorted[mid]) {
            return mid;
        }
        if (value > sorted[mid]) {
            return helper(value, sorted, mid + 1, right);
        }
        return helper(value, sorted, left, mid - 1);
    }

    /**
     * 探探算法：链表翻转
     */
    @org.junit.Test
    public ListNode reverseList(ListNode head) {
        // leetcode num206
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //====================分割线=======================

}

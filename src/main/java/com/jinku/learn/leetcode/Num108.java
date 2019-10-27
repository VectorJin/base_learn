package com.jinku.learn.leetcode;

/**
 * 将有序数组转换为二叉搜索树
 */
public class Num108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(0);
        helper(root, nums, 0, nums.length - 1);
        return root;
    }

    private void helper(TreeNode node, int[] nums, int from, int end) {
        if (from < 0 || end >= nums.length || from > end) {
            return;
        }
        int mid = (end - from) / 2 + from;
        node.val = nums[mid];

        if (from < mid) {
            TreeNode left = new TreeNode(0);
            node.left = left;
            helper(left, nums, from, mid -1);
        }

        if (end > mid) {
            TreeNode right = new TreeNode(0);
            node.right = right;

            helper(right, nums, mid + 1, end);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

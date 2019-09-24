package com.jinku.demo.leetcode;

import sun.nio.cs.ext.MacArabic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 二叉树中的最大路径和
 */
public class Num124 {

    int max = Integer.MIN_VALUE;

    public int max_gain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMax = Math.max(max_gain(node.left), 0);
        int rightMax = Math.max(max_gain(node.right), 0);

        max = Math.max(max, node.val + leftMax + rightMax);

        return node.val + Math.max(leftMax, rightMax);
    }

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max;
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

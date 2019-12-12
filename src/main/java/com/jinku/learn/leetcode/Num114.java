package com.jinku.learn.leetcode;

/**
 * 二叉树展开为链表
 */
public class Num114 {

    public void flatten(TreeNode root) {
        helper(root, null);
    }

    public TreeNode helper(TreeNode node, TreeNode last) {
        if (node == null) {
            return null;
        }

        if (last != null) {
            last.left = null;
            last.right = node;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = null;
        node.right = left;

        TreeNode leftest = helper(left, node);
        TreeNode rightest;
        if (leftest == null) {
            rightest = helper(right, node);
        } else {
            rightest = helper(right, leftest);
        }
        if (leftest == null && rightest == null) {
            return node;
        }
        return rightest == null ? leftest : rightest;
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

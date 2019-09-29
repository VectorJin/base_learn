package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最近公共祖先
 */
public class Num236 {

    TreeNode target = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        return target;
    }

    private boolean traverse(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }

        int mid = 0;
        if (node == p || node == q) {
            mid = 1;
        }

        int left = traverse(node.left, p, q) ? 1 : 0;
        int right = traverse(node.right, p, q)? 1 : 0;
        if (left + right + mid >= 2) {
            target = node;
        }
        return left + right + mid > 0;
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

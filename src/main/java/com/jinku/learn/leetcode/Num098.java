package com.jinku.learn.leetcode;

/**
 * 验证二叉搜索树
 */
public class Num098 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode parent, Integer min, Integer max) {
        if (parent == null) {
            return true;
        }

        if (min != null && parent.val <= min) {
            return false;
        }

        if (max != null && parent.val >= max) {
            return false;
        }

        return isValidBST(parent.left, min, parent.val) && isValidBST(parent.right, parent.val, max);
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

package com.jinku.learn.leetcode;

/**
 * 合并二叉树
 */
public class Num617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode node = new TreeNode(0);

        int val = 0;
        if (t1 != null) {
            val += t1.val;
        }
        if (t2 != null) {
            val += t2.val;
        }
        node.val = val;

        node.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        node.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return node;
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

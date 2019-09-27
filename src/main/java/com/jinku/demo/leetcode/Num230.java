package com.jinku.demo.leetcode;

/**
 * 二叉搜索树中第K小的元素
 */
public class Num230 {

    int index = 0;
    int total = 0;
    int value = 0;
    public int kthSmallest(TreeNode root, int k) {
        total = k;
        innerTraverse(root);
        return value;
    }

    private void innerTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        innerTraverse(node.left);
        if (index >= total) {
            return;
        }
        value = node.val;
        index++;
        innerTraverse(node.right);

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

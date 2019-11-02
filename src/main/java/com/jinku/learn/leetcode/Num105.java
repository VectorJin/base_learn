package com.jinku.learn.leetcode;

/**
 * 从前序与中序遍历序列构造二叉树
 */
public class Num105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
        TreeNode parentNode = new TreeNode(preorder[preL]);

        int leftCount = 0;
        for (int i = inL; i <= inR; i++) {
            if (inorder[i] == parentNode.val) {
                break;
            }
            leftCount++;
        }

        if (leftCount == 0) {
            parentNode.left = null;
        } else {
            parentNode.left = helper(preorder, inorder, preL + 1, (preL + leftCount), inL, inL + leftCount - 1);
        }

        int rightCount = (preR - preL - leftCount);
        if (rightCount <= 0) {
            parentNode.right = null;
        } else {
            parentNode.right = helper(preorder, inorder, preL + leftCount + 1, preR, inL + leftCount + 1, inR);
        }
        return parentNode;
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


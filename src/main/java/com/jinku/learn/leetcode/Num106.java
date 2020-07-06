package com.jinku.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 */
public class Num106 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        Map<Integer, Integer> indexMap = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length == 0) {
                return null;
            }
            for (int i = 0; i < inorder.length; i++) {
                indexMap.put(inorder[i], i);
            }
            return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        }

        private TreeNode helper(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR) {
            TreeNode parentNode = new TreeNode(postorder[postR]);
            int index = indexMap.get(postorder[postR]);

            // 重建左子树
            if (index == inL) {
                parentNode.left = null;
            } else {
                parentNode.left = helper(inorder, postorder, inL, index - 1, postL, postL + (index - inL - 1));
            }
            // 重建右子树
            if (index == inR) {
                parentNode.right = null;
            } else {
                parentNode.right = helper(inorder, postorder, index + 1, inR, postL + (index - inL), postR - 1);
            }
            return parentNode;
        }
    }

}

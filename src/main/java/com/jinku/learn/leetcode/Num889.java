package com.jinku.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据前序和后序遍历构造二叉树
 */
public class Num889 {

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

        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            if (pre.length == 0 || post.length == 0) {
                return null;
            }
            for (int i = 0; i < post.length; i++) {
                indexMap.put(post[i], i);
            }
            return helper(pre, post, 0, pre.length - 1, 0, post.length - 1);
        }

        private TreeNode helper(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR) {
            if (inL > inR || postL > postR) {
                return null;
            }
            TreeNode parentNode = new TreeNode(inorder[inL]);
            if (inL == inR || postL == postR) {
                return parentNode;
            }
            int index = indexMap.get(inorder[inL + 1]);
            // 重建左子树
            parentNode.left = helper(inorder, postorder, inL + 1, inL + 1 + (index - postL), postL, index);
            // 重建右子树
            parentNode.right = helper(inorder, postorder, inL + 2 + (index - postL), inR, index + 1, postR - 1);
            return parentNode;
        }
    }
}

package com.jinku.learn.leetcode;

/**
 * 树的子结构
 */
public class Offer26 {

    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            // 遍历A所有节点
            return (A != null && B != null) && (isSame(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
        }

        private boolean isSame(TreeNode A, TreeNode B) {
            if (B == null) {
                return true;
            }
            if (A == null) {
                return false;
            }
            return A.val == B.val && isSame(A.left, B.left) && isSame(A.right, B.right);
        }
    }

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

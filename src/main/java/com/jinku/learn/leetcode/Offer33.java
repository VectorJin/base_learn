package com.jinku.learn.leetcode;

/**
 * 二叉搜索树的后序遍历序列
 */
public class Offer33 {
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return helper(postorder, 0, postorder.length - 1);
        }

        private boolean helper(int[] postorder, int left, int right) {
            // 只有一个元素直接返回true
            if (left >= right) {
                return true;
            }
            // 根节点
            int root = postorder[right];
            // 划分左子树和右子树
            int index = -1;
            for (int i = left; i <= right; i++) {
                // 找出左右子树的分界点，即小中大模式
                if (postorder[i] > root && index == -1) {
                    index = i;
                }
                if (postorder[i] < root && index != -1) {
                    // 不满足二叉搜索树的定义，即小中大模式
                    return false;
                }
            }
            if (index == -1 || index == left) {//只有左子树 或者 只有右子树
                return helper(postorder, left, right - 1);
            }
            return helper(postorder, left, index - 1) && helper(postorder, index, right - 1);
        }
    }
}

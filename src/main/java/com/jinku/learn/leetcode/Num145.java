package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的后序遍历
 */
public class Num145 {

    class Solution {
        /**
         * 非递归写法
         *
         * @param root
         * @return
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode current = root;
            while (current != null || !stack.isEmpty()) {
                // 当前节点以及所有左子节点入栈
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }

                // 直到左子节点为空
                TreeNode node = stack.poll();

                // 处理右子树
                if (node.right != null && (stack.isEmpty() || node != stack.peek())) {
                    // 右子节点不为空，当前节点再次入栈，用于判断
                    stack.push(node);
                    stack.push(node);
                    // 接着处理右子节点
                    current = node.right;
                } else {
                    // 右子节点为空或者已经处理右子树，输出当前节点
                    ans.add(node.val);
                    if (!stack.isEmpty() && node == stack.peek()) {
                        // 移除多余的节点
                        stack.poll();
                    }
                }
            }
            return ans;
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

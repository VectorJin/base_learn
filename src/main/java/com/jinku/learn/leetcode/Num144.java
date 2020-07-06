package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 */
public class Num144 {

    class Solution {
        /**
         * 非递归写法
         *
         * @param root
         * @return
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode current = root;

            while (current != null || !stack.isEmpty()) {
                // 将当前节点以及所有的左子节点入栈，同时直接访问
                while (current != null) {
                    ans.add(current.val);
                    stack.push(current);
                    current = current.left;
                }
                // 处理右子树
                current = stack.poll().right;
            }
            return ans;
        }
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

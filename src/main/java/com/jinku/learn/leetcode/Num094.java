package com.jinku.learn.leetcode;

import java.util.*;

/**
 * 二叉树的中序遍历
 */
public class Num094 {

    /**
     * 递归写法
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private void helper(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        helper(node.left, ans);
        ans.add(node.val);
        helper(node.right, ans);
    }

    /**
     * 迭代写法
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Set<TreeNode> visitedSet = new HashSet<>();
        // 利用栈来迭代
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !visitedSet.contains(node.left)) {
                // 左子节点不为空，继续加入到栈中
                stack.push(node.left);
            } else {
                // 左子节点为空，当前节点出栈，并且访问
                stack.poll();
                ans.add(node.val);
                visitedSet.add(node);
                // 右子节点不为空，则入栈
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return ans;
    }

    /**
     * 迭代写法 标准
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // 将当前节点以及所有左子节点将入到栈中
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            // 当前节点出栈并访问
            TreeNode node = stack.poll();
            ans.add(node.val);
            // 处理右子树
            current = node.right;
        }
        return ans;
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

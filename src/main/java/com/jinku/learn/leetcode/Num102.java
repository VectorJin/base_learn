package com.jinku.learn.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 */
public class Num102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class InnerTreeNode {
        int val;
        int level;
        TreeNode left;
        TreeNode right;

        InnerTreeNode(TreeNode treeNode, int level) {
            this.left = treeNode.left;
            this.right = treeNode.right;
            this.val = treeNode.val;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<InnerTreeNode> queue = new ArrayDeque<>();
        queue.add(new InnerTreeNode(root, 1));
        int level = -1;
        List<Integer> levelList = null;
        while (!queue.isEmpty()) {
            InnerTreeNode node = queue.poll();
            if (node.level != level) {
                levelList = new ArrayList<>();
                ans.add(levelList);
                level = node.level;
            }
            levelList.add(node.val);

            if (node.left != null) {
                queue.add(new InnerTreeNode(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new InnerTreeNode(node.right, level + 1));
            }
        }

        return ans;
    }
}

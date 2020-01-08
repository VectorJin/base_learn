package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 最大层内元素和
 */
public class Num1161 {

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int maxLevel = 0;
        int level = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int sum = 0;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (sum > max) {
                max = sum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }

    public int maxLevelSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int maxLevel = 0;
        Queue<InnerTreeNode> queue = new LinkedList<>();
        queue.offer(new InnerTreeNode(1, root));
        int level = 1;
        int sum = 0;

        while (!queue.isEmpty()) {

            InnerTreeNode current = queue.poll();
            if (current.level == level) {
                sum += current.val;
            } else {

                if (sum > max) {
                    maxLevel = level;
                    max = sum;
                }

                sum = current.val;
                level = current.level;
            }

            if (current.left != null) {
                queue.offer(new InnerTreeNode(current.level + 1, current.left));
            }
            if (current.right != null) {
                queue.offer(new InnerTreeNode(current.level + 1, current.right));
            }
        }

        if (sum > max) {
            maxLevel = level;
        }

        return maxLevel;
    }

    public class InnerTreeNode extends TreeNode {
        public int level;

        public InnerTreeNode(int level, TreeNode node) {
            super(node.val);
            super.left = node.left;
            super.right = node.right;
            this.level = level;
        }
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

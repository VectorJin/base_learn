package com.jinku.learn.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的锯齿形层次遍历
 */
public class Num103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        Deque<InnerTreeNode> deque = new ArrayDeque<>();
        deque.addLast(new InnerTreeNode(root, 1));
        boolean fromLeft = true;
        List<Integer> levelList = new ArrayList<>();
        ans.add(levelList);
        int curLevel = 1;
        while (!deque.isEmpty()) {

            // 新的一层，改变遍历顺序
            InnerTreeNode node;

            if (fromLeft) {
                node = deque.peekFirst();
            } else {
                node = deque.peekLast();
            }

            if (node.level > curLevel) {
                fromLeft = !fromLeft;
                levelList = new ArrayList<>();
                ans.add(levelList);
            }

            if (fromLeft) {
                node = deque.pollFirst();
            } else {
                node = deque.pollLast();
            }

            levelList.add(node.val);

            if (node.level > curLevel) {

                if (fromLeft) {
                    if (node.left != null) {
                        deque.addLast(new InnerTreeNode(node.left, node.level + 1));
                    }
                    if (node.right != null) {
                        deque.addLast(new InnerTreeNode(node.right, node.level + 1));
                    }
                } else {
                    if (node.right != null) {
                        deque.addFirst(new InnerTreeNode(node.right, node.level + 1));
                    }
                    if (node.left != null) {
                        deque.addFirst(new InnerTreeNode(node.left, node.level + 1));
                    }
                }
            }
            curLevel = node.level;
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

    public class InnerTreeNode extends TreeNode {
        int level;

        InnerTreeNode(TreeNode node, int level) {
            super(node.val);
            left = node.left;
            right = node.right;
            this.level = level;
        }
    }
}

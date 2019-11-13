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
        if(root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        boolean fromLeft = true;
        List<Integer> levelList = new ArrayList<>();
        ans.add(levelList);
        while (!deque.isEmpty()) {

            int size = deque.size();
            for (int i = 1; i <= size;i++) {
                TreeNode node = deque.pollFirst();
                if (fromLeft) {
                    levelList.add(node.val);
                } else {
                    levelList.add(0, node.val);
                }

                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }

            if (!deque.isEmpty()) {
                // 新的一层
                levelList = new ArrayList<>();
                ans.add(levelList);
                fromLeft = !fromLeft;
            }
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

package com.jinku.learn.leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化二叉树
 */
public class Offer37 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val);
                    sb.append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    sb.append("null,");
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] strings = data.split(",");
            if (strings.length == 0 || strings[0].equals("") || strings[0].equals("null")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int index = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (!strings[index].equals("") && !strings[index].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(strings[index]));
                    queue.add(node.left);
                }
                index++;

                if (!strings[index].equals("") && !strings[index].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(strings[index]));
                    queue.add(node.right);
                }
                index++;
            }
            return root;
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

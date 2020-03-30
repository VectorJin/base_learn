package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 平衡二叉树（高度 平衡）
 */
public class Num101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Integer.max(height(root.left), height(root.right));
    }

    // ================== 以下实现是深度差不超过1的平衡树=====================
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        iterate(root, list, 0);
        if (list.size() == 1) {
            return true;
        }
        return list.get(1) - list.get(0) < 2;
    }

    private void iterate(TreeNode root, List<Integer> list, int number) {
        if (root == null) {
            if (list.size() == 0) {
                list.add(number);
            } else if (list.size() == 1) {
                if (list.get(0) < number) {
                    list.add(number);
                }
                if (list.get(0) > number) {
                    list.add(0, number);
                }
            } else {
                int min = list.get(0);
                int max = list.get(1);

                if (number < min) {
                    list.remove(0);
                    list.add(0, number);
                }
                if (number > max) {
                    list.remove(1);
                    list.add(number);
                }
            }
            return;
        }
        number++;
        iterate(root.left, list, number);
        iterate(root.right, list, number);
    }

}

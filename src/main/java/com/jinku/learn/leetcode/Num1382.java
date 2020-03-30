package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 将二叉搜索树变平衡
 */
public class Num1382 {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> orderedList = new ArrayList<>();
        // 中序遍历原有二叉树，即排序
        iterate(root, orderedList);
        if (orderedList.size() == 0) {
            return null;
        }
        // 使用二分法重建二叉搜索树
        return rebuildVAL(new TreeNode(0), orderedList, 0, orderedList.size() - 1);
    }

    private void iterate(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            iterate(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            iterate(root.right, list);
        }
    }

    private TreeNode rebuildVAL(TreeNode root, List<Integer> list, int start, int end) {

        int mid = (end - start) / 2 + start;
        root.val = list.get(mid);

        if (mid - start >= 1) {
            TreeNode left = new TreeNode(0);
            root.left = left;
            rebuildVAL(left, list, start, mid - 1);
        }

        if (end - mid >= 1) {
            TreeNode right = new TreeNode(0);
            root.right = right;
            rebuildVAL(right, list, mid + 1, end);
        }
        return root;
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

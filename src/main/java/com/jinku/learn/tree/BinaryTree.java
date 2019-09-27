package com.jinku.learn.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by jinku on 2018/3/5.
 */
public class BinaryTree {

    private final static String preOrderStr = "GDAFEMHZ";
    private final static String midOrderStr = "ADEFGHMZ";

    public TreeNode createTree(String preOrderStr, String midOrderStr) {
        System.out.println(preOrderStr + "====" + midOrderStr);
        if (preOrderStr == null || midOrderStr == null) {
            return null;
        }
        if ("".equals(preOrderStr) || "".equals(midOrderStr)) {
            return null;
        }

        TreeNode treeNode = new TreeNode();
        if (preOrderStr.length() == 1) {
            treeNode.value = preOrderStr;
            return treeNode;
        }

        char rootStr = preOrderStr.charAt(0);
        treeNode.value = String.valueOf(rootStr);

        char[] strChar = midOrderStr.toCharArray();
        int rootIndex = 0;
        int index = 0;
        for (char str : strChar) {
            if (str == rootStr) {
                rootIndex = index;
            }
            index++;
        }

        String leftMidChildStr = midOrderStr.substring(0, rootIndex);
        String rightMidChildStr = midOrderStr.substring(rootIndex + 1);

        String leftPreChildStr = null;
        int leftMidChildStrLength = 0;
        if (leftMidChildStr != null) {
            leftMidChildStrLength = leftMidChildStr.length();
        }

        if (leftMidChildStrLength != 0) {
            leftPreChildStr = preOrderStr.substring(1, leftMidChildStrLength + 1);
        }

        String rightPreChildStr = preOrderStr.substring(leftMidChildStrLength + 1);

        treeNode.leftChild = createTree(leftPreChildStr, leftMidChildStr);
        treeNode.rightChild = createTree(rightPreChildStr, rightMidChildStr);
        return treeNode;
    }

    public void preTraverseTree(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        System.out.print(rootNode.value);
        preTraverseTree(rootNode.leftChild);
        preTraverseTree(rootNode.rightChild);
    }

    public void preTraverseTreeNonRecur(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = rootNode;

        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.print(treeNode.value);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.peek();
                stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    public void midTraverseTree(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        midTraverseTree(rootNode.leftChild);
        System.out.print(rootNode.value);
        midTraverseTree(rootNode.rightChild);
    }

    public void midTraverseTreeNonRecur(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = rootNode;

        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.peek();
                stack.pop();
                System.out.print(treeNode.value);
                treeNode = treeNode.rightChild;
            }
        }

    }

    public void postTraverseTree(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        postTraverseTree(rootNode.leftChild);
        postTraverseTree(rootNode.rightChild);
        System.out.print(rootNode.value);
    }

    public void postTraverseTreeNonRecur(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        Map<String, Integer> keyMap = new HashMap<String, Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = rootNode;
        TreeNode parentNode = null;

        while (treeNode != null || !stack.isEmpty()) {

            // 左右节点不为空, 并且左右节点节点都已访问
            if (new Integer(2).equals(keyMap.get(treeNode.value))) {
                System.out.print(treeNode.value);
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                treeNode = stack.peek();
                continue;
            }

            // 遍历左子节点 到头
            while (treeNode != null && keyMap.get(treeNode.value) == null) {
                stack.push(treeNode);
                // 左子节点已访问
                keyMap.put(treeNode.value, 1);
                treeNode = treeNode.leftChild;
            }

            // 切换到右子节点
            if (!stack.isEmpty()) {
                treeNode = stack.peek();
                parentNode = treeNode;
                treeNode = treeNode.rightChild;
                // 右子节点已访问
                keyMap.put(parentNode.value, 2);
            }

            // 右子节点为空的情况
            if (treeNode == null) {
                System.out.print(parentNode.value);
                stack.pop();
                treeNode = stack.peek();
            }
        }
    }

    public static class TreeNode {
        public String value;
        public TreeNode leftChild;
        public TreeNode rightChild;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode rootNode = binaryTree.createTree(preOrderStr, midOrderStr);
//        binaryTree.preTraverseTree(rootNode);
//        System.out.println();
//        binaryTree.preTraverseTreeNonRecur(rootNode);
//        binaryTree.midTraverseTree(rootNode);
//        System.out.println();
//        binaryTree.midTraverseTreeNonRecur(rootNode);
//        System.out.println();
        binaryTree.postTraverseTree(rootNode);
        System.out.println();
        binaryTree.postTraverseTreeNonRecur(rootNode);
    }
}

package com.jinku.learn.leetcode;

/**
 * 不邻接植花
 */
public class Num1042 {

    public int[] gardenNoAdj(int N, int[][] paths) {

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(null, i + 1);
        }

        for (int[] item : paths) {
            addNode(nodes[item[0] - 1], item[1]);
            addNode(nodes[item[1] - 1], item[0]);
        }
        int[] result = new int[N];

        for (Node node : nodes) {
            int[] colorArray = new int[4];
            Node curNode = node;
            while (curNode.next != null) {
                int color = result[curNode.next.value - 1];
                if (color != 0) {
                    colorArray[color -1] = 1;
                }

                curNode = curNode.next;
            }

            for (int flower = 1; flower <= 4; flower++) {
                if (colorArray[flower -1] == 0) {
                    result[node.value - 1] = flower;
                    break;
                }
            }
        }

        return result;
    }

    public void addNode(Node node, int value) {
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(null, value);
    }

    public static class Node {

        Node next;
        int value;

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }
    }

}

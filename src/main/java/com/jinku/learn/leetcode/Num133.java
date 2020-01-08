package com.jinku.learn.leetcode;

import java.util.*;

/**
 * 克隆图
 */
public class Num133 {

    public Node cloneGraphBFS(Node node) {
        if (node == null) {
            return null;
        }
        Node first = null;
        Map<Node, Node> nodeMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        Node copiedNode = new Node(node.val);
        copiedNode.neighbors = new ArrayList<>();
        nodeMap.put(node, copiedNode);

        first = copiedNode;

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.neighbors == null) {
                continue;
            }
            for (Node neighbor : current.neighbors) {

                if (!nodeMap.containsKey(neighbor)) {
                    Node copiedNeighbor = new Node(neighbor.val);
                    copiedNeighbor.neighbors = new ArrayList<>();
                    nodeMap.put(neighbor, copiedNeighbor);
                    queue.offer(neighbor);
                }

                nodeMap.get(current).neighbors.add(nodeMap.get(neighbor));
            }
        }
        return first;
    }

    public Node cloneGraphDFS(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        Node copied = map.get(node);
        if (copied != null) {
            return copied;
        }

        copied= new Node(node.val);
        copied.neighbors = new ArrayList<>();
        map.put(node, copied);

        if (node.neighbors != null) {
            for (Node neighbor : node.neighbors) {
                copied.neighbors.add(dfs(neighbor, map));
            }
        }
        return copied;
    }


    class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
    }
}

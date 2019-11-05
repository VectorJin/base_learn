package com.jinku.learn.leetcode;

import java.util.*;

/**
 * 前 K 个高频元素
 */
public class Num347 {

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>(k);
        if (nums == null || nums.length == 0) {
            return ans;
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(k);

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new Node(entry.getKey(), entry.getValue()));
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        while (!priorityQueue.isEmpty()) {
            ans.add(priorityQueue.poll().key);
        }

        return ans;
    }

    public static class Node implements Comparable<Node> {
        Integer key;
        Integer count;

        public Node(Integer key, Integer count) {
            this.key = key;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return count.compareTo(o.count);
        }
    }
}

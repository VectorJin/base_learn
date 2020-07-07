package com.jinku.learn.leetcode;

import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 */
public class Offer59 {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k == 0 || k > nums.length) {
                return new int[0];
            }
            if (k == 1) {
                return nums;
            }
            int[] ans = new int[nums.length - k + 1];
            PriorityQueue<Node> bigHeap = new PriorityQueue<>(k, (x, y) -> (y.val - x.val));
            int index = -1;
            for (int i = 0; i < nums.length; i++) {
                bigHeap.add(new Node(nums[i], i));
                if (bigHeap.size() >= k) {
                    while (true) {
                        Node node = bigHeap.peek();
                        if (i - node.index >= k) {
                            bigHeap.poll();
                        } else {
                            ans[++index] = node.val;
                            break;
                        }
                    }
                }
            }
            return ans;
        }

        class Node {
            int val;
            int index;

            Node(int val, int index) {
                this.val = val;
                this.index = index;
            }
        }
    }
}

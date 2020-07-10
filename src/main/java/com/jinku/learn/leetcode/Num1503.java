package com.jinku.learn.leetcode;

/**
 * 所有蚂蚁掉下来前的最后一刻
 */
public class Num1503 {
    class Solution {
        public int getLastMoment(int n, int[] left, int[] right) {
            int ans = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < left.length; i++) {
                if (left[i] > max) {
                    max = left[i];
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < right.length; i++) {
                if (right[i] < min) {
                    min = right[i];
                }
            }
            ans = Math.max(n - min, max);
            return ans;
        }
    }
}

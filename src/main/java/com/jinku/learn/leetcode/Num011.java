package com.jinku.learn.leetcode;

/**
 * 盛最多水的容器
 */
public class Num011 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int max = 0;
        while (i < j) {
            int left = height[i];
            int right = height[j];
            int tmp = Math.min(left, right) * (j - i);
            if (tmp > max) {
                max = tmp;
            }
            if (left > right) {
                j--;
            } else if (left < right) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return max;
    }
}

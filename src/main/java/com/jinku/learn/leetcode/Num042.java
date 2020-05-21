package com.jinku.learn.leetcode;

/**
 * 接雨水
 */
public class Num042 {

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        while (left <= right) {
            if (leftMax <= rightMax) {
                ans += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                ans += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(array));
    }
}

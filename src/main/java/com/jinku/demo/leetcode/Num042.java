package com.jinku.demo.leetcode;

/**
 * 接雨水
 */
public class Num042 {

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] <= 0) {
                continue;
            }
            // 找到第一个大于等于的index
            int left = height[i];
            int rightIndex = -1;
            // 记录遇到的最大的值
            int max = 0;
            int maxIndex = -1;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max) {
                    max = height[j];
                    maxIndex = j;
                }
                if (height[j] >= left) {
                    rightIndex = j;
                    break;
                }
            }
            if (rightIndex != -1) {
                // 计算值
                for (int x = i + 1; x < rightIndex; x++) {
                    result += (left - height[x]);
                }
                i = rightIndex - 1;
            } else {
                if (maxIndex != -1 && left > max) {
                    // 计算值
                    for (int x = i + 1; x < maxIndex; x++) {
                        result += (max - height[x]);
                    }
                    i = maxIndex - 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(array));
    }
}

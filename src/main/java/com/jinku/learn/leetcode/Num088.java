package com.jinku.learn.leetcode;

/**
 * 合并两个有序数组
 */
public class Num088 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1 将元素右移 n 位
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }

        int i = n;
        int j = 0;

        int index = 0;
        while (i < (n + m) && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums1[index] = nums1[i];
                i++;
            } else {
                nums1[index] = nums2[j];
                j++;
            }
            index++;
        }

        if (j < n) {
            for (; j < n; j++) {
                nums1[index] = nums2[j];
                index++;
            }
        }
    }
}

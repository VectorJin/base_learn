package com.jinku.learn.leetcode;

import java.util.Arrays;

/**
 * 下一个排列
 */
public class Num031 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = -1;
        int right = -1;
        // 找到需要交换的位置
        for (int i = nums.length - 1; i >= 0 && left == -1; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    left = i;
                    right = j;
                    break;
                }
            }
        }

        if (left == -1) {
            // 没找到，则翻转
            int midIndex = nums.length / 2;
            for (int i = 0; i < midIndex; i++) {
                int tmp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = tmp;
            }
        } else {
            // 交换数据后，将left索引之后的排序即可
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            Arrays.sort(nums, left + 1, nums.length);
        }
    }
}

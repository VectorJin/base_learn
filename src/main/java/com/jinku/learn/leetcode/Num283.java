package com.jinku.learn.leetcode;

/**
 * 移动零
 */
public class Num283 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int zeroCount = 0;
        for (int i = 0; i<nums.length;i++) {
            if (nums[i] == 0) {
                zeroCount++;
                continue;
            }
            if (zeroCount != 0) {
                nums[i - zeroCount] = nums[i];
                nums[i] = 0;
            }
        }
    }
}

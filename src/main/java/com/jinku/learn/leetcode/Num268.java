package com.jinku.learn.leetcode;

/**
 * 缺失数字
 */
public class Num268 {

    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}

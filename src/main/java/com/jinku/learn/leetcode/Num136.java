package com.jinku.learn.leetcode;

/**
 * 只出现一次的数字
 */
public class Num136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }
}

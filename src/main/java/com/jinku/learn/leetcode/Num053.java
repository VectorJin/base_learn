package com.jinku.learn.leetcode;

/**
 * 最大子序和
 */
public class Num053 {

    /**
     * 双指针法
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right];
            max = Math.max(max, sum);

            if (sum <= 0) {
                left++;
                right = left;
                sum = 0;
            } else {
                right++;
            }
        }

        return max;
    }
}

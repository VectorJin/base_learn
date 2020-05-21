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
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[left] > max) {
                max = nums[left];
            }
            if (nums[left] <= 0) {
                sum = 0;
                left++;
                right++;
                continue;
            }

            if (left == right) {
                sum = nums[left];
                right++;
            } else {
                if (nums[right] + sum <= 0) {
                    left = right + 1;
                    right++;
                    sum = 0;
                } else {
                    sum += nums[right];
                    if (sum > max) {
                        max = sum;
                    }
                    right++;
                }
            }
        }
        return max;
    }
}

package com.jinku.learn.leetcode;

/**
 * 最长上升子序列
 */
public class Num300 {

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            // 对于每新增一个元素，需要重新计算dp
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], (dp[j] + 1));
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    /**
     * 贪心 + 二分查找
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int[] tails = new int[nums.length];
        for (int num : nums) {
            // 使用二分法定位
            int i = 0;
            int j = res;

            while (i < j) {
                int m = (j - i) / 2 + i;
                if (num <= tails[m]) {
                    j = m;
                } else {
                    i = m + 1;
                }
            }
            tails[i] = num;
            if (res == j) {
                res++;
            }
        }
        return res;
    }
}

package com.jinku.learn.leetcode;

/**
 * 最佳买卖股票时机含冷冻期
 */
public class Num309 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2, 1, 4}));
    }

    /**
     * 通用解法:动态规划
     * <p>
     * 状态变量
     * n（哪一天）, k（最大交易次数，买入和卖出算一次）, h（是否持有股票）
     * 选择操作
     * buy买入
     * sell卖出
     * rest休息
     * dp[n][k][h] 表示在n, k, h状态下的最大收益
     * 状态转移方程
     * 当前没有持有
     * dp[n][k][0] = max(dp[n-1][k][0], dp[n-1][k][1] + prices[n])
     * 当前持有股票
     * dp[n][k][1] = max(dp[n-1][k][1], dp[n-2][k-1][0] - prices[n])
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // k 不限
        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = 0 - prices[0];
                continue;
            }
            if (i == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}

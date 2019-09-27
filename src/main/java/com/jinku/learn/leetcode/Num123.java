package com.jinku.learn.leetcode;

/**
 * 买卖股票的最佳时机 III
 */
public class Num123 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
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
     * dp[n][k][1] = max(dp[n-1][k][1], dp[n-1][k-1][0] - prices[n])
     *
     * 遍历所有的状态
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // k 最大为2
        int K = 2;
        int[][][] dp = new int[prices.length][K + 1][2];

        for (int i = 0; i < prices.length; i++) {
            for (int k = 0; k <= K; k++) {
                if (k == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = 0;
                    continue;
                }

                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = 0 - prices[i];
                    continue;
                }

                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][K][0];
    }

}

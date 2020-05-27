package com.jinku.learn.leetcode;

/**
 * 零钱兑换
 */
public class Num322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        return helper(dp, coins, amount);
    }

    public int helper(int[] dp, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }

        int min = -1;
        for(int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) {
                continue;
            }
            int tmp = helper(dp, coins, amount - coins[i]);
            if (tmp == -1) {
                continue;
            }
            if (min == -1) {
                min = tmp;
            } else {
                min = Math.min(min, tmp);
            }
        }
        if (min != -1) {
            dp[amount] = min + 1;
        } else {
            dp[amount] = -1;
        }
        return dp[amount];
    }
}

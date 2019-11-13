package com.jinku.learn.leetcode;

/**
 * 完全平方数
 */
public class Num279 {

    public static void main(String[] args) {
        System.out.println(numSquares(16));
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}

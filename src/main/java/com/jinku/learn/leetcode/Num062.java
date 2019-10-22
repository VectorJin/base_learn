package com.jinku.learn.leetcode;

/**
 * 不同路径
 */
public class Num062 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(19, 13));
    }

    /**
     * 动态规划
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int top = dp[i - 1][j];
                int left = dp[i][j - 1];
                if (i == 1) {
                    top = 0;
                }
                if (j == 1) {
                    left = 0;
                }
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = top + left;
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 递归实现
     *
     * @param x
     * @param y
     * @return
     */
    private static int helper(int x, int y) {
        if (x == 0 || y == 0) {
            return 0;
        }
        if (x == 1 && y == 1) {
            return 1;
        }

        return helper(x - 1, y) + helper(x, y - 1);
    }
}

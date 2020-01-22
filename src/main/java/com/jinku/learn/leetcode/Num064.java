package com.jinku.learn.leetcode;

/**
 * 最小路径和
 */
public class Num064 {

    public int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] dp = new int[x][y];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (dp[i][j] != 0) {
                    continue;
                }
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    continue;
                }

                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[x - 1][y - 1];
    }

    public int minPathSum2(int[][] grid) {
        return helper(grid, 0, 0);
    }

    private int helper(int[][] grid, int x, int y) {
        int sum = 0;
        if (x >= grid.length || y >= grid[0].length) {
            return sum;
        }

        sum += grid[x][y];
        if (x == grid.length - 1) {
            sum += helper(grid, x, y + 1);
            return sum;
        }

        if (y >= grid[0].length - 1) {
            sum += helper(grid, x + 1, y);
            return sum;
        }

        sum += Math.min(helper(grid, x + 1, y), helper(grid, x, y + 1));
        return sum;
    }
}

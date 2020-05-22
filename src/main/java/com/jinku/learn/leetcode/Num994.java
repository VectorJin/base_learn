package com.jinku.learn.leetcode;

/**
 * 腐烂的橘子
 */
public class Num994 {

    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        int goodCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    goodCount++;
                }
            }
        }
        int lastGoodCount = goodCount;
        while (goodCount > 0) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 2) {
                        continue;
                    }
                    // 广度优先向上下左右四个方向进行扩散
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        goodCount--;
                        grid[i][j - 1] = 3;//中间状态，本轮不可用
                    }
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        goodCount--;
                        grid[i][j + 1] = 3;//中间状态，本轮不可用
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        goodCount--;
                        grid[i - 1][j] = 3;//中间状态，本轮不可用
                    }
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        goodCount--;
                        grid[i + 1][j] = 3;//中间状态，本轮不可用
                    }
                }
            }
            if (lastGoodCount == goodCount) {
                // 没有变化，说明不可能
                return -1;
            }
            ans++;
            lastGoodCount = goodCount;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 3) {
                        grid[i][j] = 2;
                    }
                }
            }
        }
        return ans;
    }
}

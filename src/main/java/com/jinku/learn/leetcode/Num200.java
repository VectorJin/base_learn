package com.jinku.learn.leetcode;

import org.junit.Test;

/**
 * 岛屿数量
 */
public class Num200 {

    private boolean[][] visited;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0' || visited[i][j]) {
                    continue;
                }
                ans++;
                helper(i, j);
            }
        }
        return ans;
    }

    public void helper(int i, int j) {
        if (i < 0 || i >= grid.length) {
            return;
        }
        if (j < 0 || j >= grid[0].length) {
            return;
        }
        if (visited[i][j] || grid[i][j] == '0') {
            return;
        }
        // 当前节点置为已访问
        visited[i][j] = true;

        // 向上下左右四个方向继续
        helper(i, j - 1);
        helper(i, j + 1);
        helper(i - 1, j);
        helper(i + 1, j);
    }

    @Test
    public void test() {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        Num200 num200 = new Num200();
        System.out.println(num200.numIslands(grid));
    }
}

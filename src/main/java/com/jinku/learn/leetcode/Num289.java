package com.jinku.learn.leetcode;

/**
 * 生命游戏
 */
public class Num289 {

    public static void main(String[] args) {
        gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
    }

    public static void gameOfLife(int[][] board) {
        if (board == null) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        // 先计算当前状态的下一状态
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = cal(board, i, j);
            }
        }
        // 更新当前状态
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
        System.out.println(board);
    }

    private static int cal(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        // 计算周围8个元素的存活数量
        int live = 0;
        int left = j - 1;
        int right = j + 1;
        int top = i + 1;
        int bottom = i - 1;

        // 从左到右
        for (int x = left; x <= right; x++) {
            if (x < 0 || x >= n) {
                continue;
            }
            if (bottom >= 0 && (board[bottom][x] == 1 || board[bottom][x] == 3)) {
                live++;
            }
            if (top < m && (board[top][x] == 1 || board[top][x] == 3)) {
                live++;
            }
        }
        if (j - 1 >= 0) {
            if (board[i][j - 1] == 1 || board[i][j - 1] == 3) {
                live++;
            }
        }
        if (j + 1 < n) {
            if (board[i][j + 1] == 1 || board[i][j + 1] == 3) {
                live++;
            }
        }

        if (board[i][j] == 1) {
            if (live < 2 || live > 3) {
                // 1 > 0
                return 3;
            }
            return 1;
        } else {
            if (live == 3) {
                return 2;
            }
            return 0;
        }
    }
}

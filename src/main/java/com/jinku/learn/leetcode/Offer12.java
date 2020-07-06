package com.jinku.learn.leetcode;

/**
 * 矩阵中的路径
 */
public class Offer12 {

    class Solution {

        char[][] board;
        char[] words;

        public boolean exist(char[][] board, String word) {
            if (board == null || word == null || board.length == 0 || word.equals("")) {
                return false;
            }
            this.board = board;
            this.words = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (helper(i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean helper(int x, int y, int index) {
            // 判断越界 或者 访问过
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != words[index]) {
                return false;
            }
            // 词全部匹配
            if (index == words.length - 1) {
                return true;
            }
            char tmp = board[x][y];
            board[x][y] = '/';
            // 继续下一词的匹配，有四种选择：上、下、左、右
            boolean ans = helper(x + 1, y, index + 1) || helper(x - 1, y, index + 1)
                    || helper(x, y + 1, index + 1) || helper(x, y - 1, index + 1);
            board[x][y] = tmp;
            return ans;
        }
    }
}

package com.jinku.learn.leetcode;

/**
 * 编辑距离
 */
public class Num072 {

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return cal(word1.length() - 1, word2.length() - 1, dp, word1, word2);
    }

    private static int cal(int l1, int l2, int[][] dp, String word1, String word2) {
        if (l1 < 0 && l2 < 0) {
            return 0;
        }
        if (l1 < 0) {
            return l2 + 1;
        }
        if (l2 < 0) {
            return l1 + 1;
        }
        if (dp[l1][l2] != -1) {
            return dp[l1][l2];
        }
        if (word1.charAt(l1) == word2.charAt(l2)) {
            dp[l1][l2] = cal(l1 - 1, l2 - 1, dp, word1, word2);
        } else {
            dp[l1][l2] = Math.min((cal(l1, l2 - 1, dp, word1, word2) + 1),
                    Math.min((cal(l1 - 1, l2, dp, word1, word2) + 1),
                            (cal(l1 - 1, l2 - 1, dp, word1, word2) + 1)));
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("a", "ab"));
    }
}

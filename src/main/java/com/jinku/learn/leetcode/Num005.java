package com.jinku.learn.leetcode;

/**
 * 最长回文子串
 */
public class Num005 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("baab"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] sArray = s.toCharArray();
        int n = sArray.length;
        boolean[][] dp = new boolean[n][n];

        String longestPalindrome = "";

        // 遍历所有的状态 (l <= r)
        for (int r = 0; r < n; r++) {
            for (int l = 0; l <= r; l++) {
                // 处理边界值
                if (l == r) {
                    dp[l][r] = true;
                } else if (r - l == 1) {
                    dp[l][r] = sArray[l] == sArray[r];
                } else if (r == 0) {
                    dp[l][r] = true;
                } else if (l == n - 1) {
                    dp[l][r] = true;
                } else {
                    // 状态转移方程
                    dp[l][r] = (sArray[l] == sArray[r]) && dp[l + 1][r - 1];
                }
                // 赋值最长的回文串
                if (dp[l][r] && longestPalindrome.length() < (r - l + 1)) {
                    longestPalindrome = s.substring(l, r + 1);
                }
            }
        }

        return longestPalindrome;
    }
}

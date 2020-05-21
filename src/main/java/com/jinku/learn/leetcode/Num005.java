package com.jinku.learn.leetcode;

/**
 * 最长回文子串
 */
public class Num005 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("baab"));
    }

    public static String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        final int n = s.length();
        boolean[][] dp = new boolean[n][n];
        char[] array = s.toCharArray();
        String ans = "";
        // 遍历所有的状态 (l <= r)
        for (int r = 0;r < n; r++) {
            for (int l = 0;l <= r; l++) {
                if (l == r || r == 0) {
                    dp[l][r] = true;
                } else if (r - l == 1) {
                    dp[l][r] = array[l] == array[r];
                } else {
                    dp[l][r] = (array[l] == array[r]) && dp[l + 1][r -1];
                }
                if (dp[l][r] && (r -l +1) > ans.length()) {
                    ans = s.substring(l, r +1);
                }
            }
        }
        return ans;
    }
}

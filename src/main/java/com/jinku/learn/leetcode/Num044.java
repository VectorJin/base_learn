package com.jinku.learn.leetcode;

/**
 * 通配符匹配
 */
public class Num044 {
    class Solution {
        char[] sArray;
        char[] pArray;
        public boolean isMatch(String s, String p) {
            if (s.length() == 0) {
                return p.length() == 0 || p.equals("*");
            }
            sArray = s.toCharArray();
            pArray = p.toCharArray();
            return helper(0, 0);
        }

        public boolean helper(int left, int right) {
            // 处理边界情况
            if (left >= sArray.length && right >= pArray.length) {
                return true;
            }
            if (left >= sArray.length) {
                if (pArray[right] == '*') {
                    return helper(left, right + 1);
                }
                return false;
            }
            if (right >= pArray.length) {
                return false;
            }

            if (sArray[left] == pArray[right] || pArray[right] == '?') {
                return helper(left + 1, right + 1);
            }
            if (pArray[right] == '*') {
                return helper(left + 1, right) || helper(left, right + 1);
            }
            return false;
        }
    }

    class Solution2 {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 1; i <= n; ++i) {
                if (p.charAt(i - 1) == '*') {
                    dp[0][i] = true;
                } else {
                    break;
                }
            }
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            return dp[m][n];
        }
    }
}

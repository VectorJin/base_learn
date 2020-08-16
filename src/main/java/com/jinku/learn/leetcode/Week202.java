package com.jinku.learn.leetcode;

/**
 * 第 202 场周赛
 */
public class Week202 {

    class Solution1 {
        public boolean threeConsecutiveOdds(int[] arr) {
            if (arr == null || arr.length < 3) {
                return false;
            }
            int count = 0;
            for (int num : arr) {
                if (num % 2 == 0) {
                    count = 0;
                } else {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
            return false;
        }
    }

    class Solution2 {
        public int minOperations(int n) {
            int ans = 0;

            int batch = n / 2;
            int mid = (1 + 2 * (n - 1) + 1) / 2;

            for (int i = 1; i <= batch; i++) {
                ans += mid;
                mid -= 2;
            }
            return ans;
        }
    }

    class Solution3 {
        public int maxDistance(int[] position, int m) {
            int ans = 0;

            return ans;
        }
    }

    class Solution4 {
        public int minDays2(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                int min = dp[i - 1];
                if (i % 3 == 0) {
                    min = Math.min(min, dp[i - 2 * (i / 3)]);
                }
                if (i % 2 == 0) {
                    min = Math.min(min, dp[i - i / 2]);
                }
                dp[i] = min + 1;
            }
            return dp[n];
        }

        public int minDays(int n) {//84806671
            int[] dp = new int[n / 2 + 2];
            dp[1] = 1;
            int pre = dp[1];
            for (int i = 2; i <= n; i++) {
                int min = pre;
                if (i % 3 == 0) {
                    min = Math.min(min, dp[i / 3]);
                }
                if (i % 2 == 0) {
                    min = Math.min(min, dp[i / 2]);
                }
                if (i < dp.length) {
                    dp[i] = min + 1;
                }
                pre = min + 1;
            }
            return pre;
        }
    }
}

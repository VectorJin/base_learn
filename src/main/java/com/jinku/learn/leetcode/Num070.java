package com.jinku.learn.leetcode;

/**
 * 爬楼梯
 */
public class Num070 {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

//        int[] dp = new int[n + 1];
//        dp[1] = 1;
//        dp[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            dp[i] = dp[i - 2] + dp[i - 1];
//        }
//        return dp[n];

        int pre_pre = 1;
        int pre = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = pre;
            pre = pre_pre + pre;
            pre_pre = tmp;
        }
        return pre;
    }
}

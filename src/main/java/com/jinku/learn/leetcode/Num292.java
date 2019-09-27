package com.jinku.learn.leetcode;

/**
 * Nim 游戏
 */
public class Num292 {

    public static void main(String[] args) {
        System.out.println(canWinNim(401));
    }

    public static boolean canWinNim(int n) {
        if (n < 4) {
            return true;
        }
        return n % 4 != 0;
    }

    public static boolean canWinNim2(int n) {
        if (n < 4) {
            return true;
        }
        boolean dp1 = true;
        boolean dp2 = true;
        boolean dp3 = true;

        boolean dpi = false;

        for (int i = 4; i <= n; i++) {
            dpi = (!dp1) || (!dp2) || (!dp3);
            dp1 = dp2;
            dp2 = dp3;
            dp3 = dpi;
        }
        return dpi;
    }

}

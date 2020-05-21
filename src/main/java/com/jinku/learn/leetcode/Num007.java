package com.jinku.learn.leetcode;

import org.junit.Test;

/**
 * 整数反转
 */
public class Num007 {

    public int reverse(int x) {
        int ans = 0;

        while (x != 0) {
            int last = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && last > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && last < -8)) {
                return 0;
            }
            ans = ans * 10 + last;
            x = x / 10;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(reverse(-2147483412));
    }
}

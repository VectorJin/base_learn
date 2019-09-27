package com.jinku.learn.leetcode;

/**
 * 整数反转
 */
public class Num007 {

    public int reverse(int x) {
        long temp = 0;

        while (x != 0) {
            int pop = x % 10;
            temp = temp * 10 + pop;

            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) temp;
    }
}

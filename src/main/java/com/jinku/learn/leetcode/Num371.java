package com.jinku.learn.leetcode;

/**
 * 两整数之和
 */
public class Num371 {

    public int getSum(int a, int b) {
        while (b != 0) {
            int res = (a & b) << 1;
            a = a ^ b;
            b = res;
        }
        return a;
    }
}

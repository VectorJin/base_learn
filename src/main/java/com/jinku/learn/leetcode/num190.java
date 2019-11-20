package com.jinku.learn.leetcode;

/**
 * 颠倒二进制位
 */
public class num190 {

    public static void main(String[] args) {
        System.out.println(reverseBits(Integer.parseInt("100111", 2)));
    }

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int i = 32;
        int res = 0;
        while (i-- > 0) {
            res <<= 1;//向左移一位
            res += n & 1;
            n >>= 1;//向右移一位
        }
        return res;
    }
}

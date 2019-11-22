package com.jinku.learn.leetcode;

/**
 * 标签：位运算
 * 数字范围按位与
 */
public class Num201 {

    public int rangeBitwiseAnd(int m, int n) {
        int count = 0; // 统计移位次数
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        n <<= count;
        return n;
    }
}

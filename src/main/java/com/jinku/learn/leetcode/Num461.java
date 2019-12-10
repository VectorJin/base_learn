package com.jinku.learn.leetcode;

/**
 * 汉明距离
 */
public class Num461 {

    public int hammingDistance(int x, int y) {
        int ans = 0;
        int xor = x ^ y;

        while (xor > 0) {
            ans += xor & 1;
            xor = xor >> 1;
        }

        return ans;
    }

}

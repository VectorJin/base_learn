package com.jinku.learn.leetcode;

/**
 * Created by jinku on 2018/6/14.
 */
public class Num365 {

    public static boolean canMeasureWater(int x, int y, int z) {
        if (z == x || z == y) {
            return true;
        }
        if (x == 0) {
            return false;
        }
        if (y == 0) {
            return false;
        }
        if (z == x + y) {
            return true;
        }
        if (z > x + y) {
            return false;
        }
        int divisor = getLargestCommonDivisor(x, y);
        return z % divisor == 0;
    }

    public static int getLargestCommonDivisor(int m, int n) {
        int min = Math.min(m, n);
        for (int i = min; i > 0; i--) {
            if (m % i == 0 && n % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(getLargestCommonDivisor(4, 6));
    }
}

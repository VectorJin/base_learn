package com.jinku.learn.leetcode;

/**
 * Created by jinku on 2018/6/13.
 */
public class Num278 {

    public static int firstBadVersion(int n) {
        int max = n;
        int min = 0;
        int count = 0;
        while (min != max -1) {
            count++;
            if (isBadVersion(n)) {
                max = n;
                int tmp = Math.max((max - min) / 2, 1);
                n = n - tmp;
            } else {
                min = n;
                int tmp = Math.max((max - min) / 2, 1);
                n = n + tmp;
            }
        }
        System.out.println(count);
        System.out.println(max);
        return max;
    }

    public static boolean isBadVersion(int n) {
        if (n >= 4) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        firstBadVersion(5);
    }
}

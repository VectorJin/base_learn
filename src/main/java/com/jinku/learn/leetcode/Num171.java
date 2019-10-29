package com.jinku.learn.leetcode;

/**
 * Excel表列序号
 */
public class Num171 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 0;
        char[] array = s.toCharArray();
        for (int i = array.length - 1; i >= 0; i--) {
            char c = array[i];
            ans += (c - 64) * (int) (Math.pow(26, (array.length - 1 - i)));
        }

        return ans;
    }
}

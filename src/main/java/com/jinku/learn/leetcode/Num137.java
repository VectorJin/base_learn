package com.jinku.learn.leetcode;

/**
 * 只出现一次的数字 II
 */
public class Num137 {

    public static void main(String[] args) {

        System.out.println(singleNumber(new int[]{2, 2, 3, 3, 2, 4, 3}));
    }

    public static int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }
        return a;
    }

}

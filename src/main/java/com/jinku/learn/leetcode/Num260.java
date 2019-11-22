package com.jinku.learn.leetcode;

/**
 * 标签：位运算
 * 只出现一次的数字 III
 */
public class Num260 {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 1, 3, 2, 5}));
    }

    public static int[] singleNumber(int[] nums) {
        int sign = 0;
        //取得数组中两个唯一数的按位异或结果
        for (int i = 0; i < nums.length; i++) {
            sign ^= nums[i];
        }
        //获取区分两个唯一数的比特位所代表的值
        //也可以写成：sign &= (~sign) + 1
        sign &= -sign;
        int[] result = new int[2];
        //通过标识，区分两个数组
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & sign) == 0)
                result[0] ^= nums[i];
            else
                result[1] ^= nums[i];
        }
        return result;
    }
}

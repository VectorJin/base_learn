package com.jinku.learn.leetcode;

import java.util.Arrays;

/**
 * 判断能否形成等差数列
 */
public class Num1502 {
    class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            if (arr == null || arr.length <= 2) {
                return true;
            }
            Arrays.sort(arr);
            int num = arr[1] - arr[0];
            int pre = arr[1];
            for (int i = 2; i < arr.length; i++) {
                if (arr[i] - pre != num) {
                    return false;
                }
                pre = arr[i];
            }
            return true;
        }
    }
}

package com.jinku.demo.leetcode;

/**
 * 回文数
 */
public class Num009 {

    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        if (xStr.length() == 1) {
            return true;
        }
        int left = 0;
        int right = xStr.length() - 1;

        char[] array = xStr.toCharArray();

        while (left <= right) {

            if (left == right) {
                return true;
            }

            if (array[left] != array[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}

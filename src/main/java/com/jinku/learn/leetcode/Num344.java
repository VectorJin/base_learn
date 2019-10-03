package com.jinku.learn.leetcode;

/**
 * 反转字符串
 */
public class Num344 {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length -1;

        while(left <= right) {

            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;

            left++;
            right--;
        }
    }

}

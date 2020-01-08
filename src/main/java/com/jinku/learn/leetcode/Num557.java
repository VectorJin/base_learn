package com.jinku.learn.leetcode;

/**
 * 反转字符串中的单词 III
 */
public class Num557 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int left = 0;
        int right = 0;
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c == ' ') {
                reverseString(array, left, right - 1);
                left = right + 1;
            }
            right++;
        }

        reverseString(array, left, array.length - 1);

        return new String(array);
    }

    public void reverseString(char[] s, int left, int right) {

        while (left <= right) {

            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;

            left++;
            right--;
        }
    }
}

package com.jinku.learn.leetcode;

/**
 * 正则表达式匹配
 */
public class Num010 {
    char[] sArray;
    char[] pArray;

    public boolean isMatch(String s, String p) {
        sArray = s.toCharArray();
        pArray = p.toCharArray();
        return helper(0, 0);
    }

    public boolean helper(int left, int right) {
        // 处理边界情况
        if (left >= sArray.length && right >= pArray.length) {
            return true;
        }
        if (left >= sArray.length) {
            if (right < pArray.length - 1 && pArray[right + 1] == '*') {
                return helper(left, right + 2);
            }
            return false;
        }
        if (right >= pArray.length) {
            return false;
        }

        boolean firstMatch = sArray[left] == pArray[right] || pArray[right] == '.';
        if (right < pArray.length - 1 && pArray[right + 1] == '*') {
            return helper(left, right + 2) || (firstMatch && (helper(left + 1, right)));
        }
        return firstMatch && helper(left + 1, right + 1);
    }
}

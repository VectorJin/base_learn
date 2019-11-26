package com.jinku.learn.leetcode;

/**
 * 找不同
 */
public class Num389 {

    public char findTheDifference(String s, String t) {
        if (s == null || s.length() == 0) {
            return t.toCharArray()[0];
        }
        char[] array = s.toCharArray();
        int xor = array[0];
        for (int i = 1; i < array.length; i++) {
            xor ^= array[i];
        }
        for (char c : t.toCharArray()) {
            xor ^= c;
        }
        return (char) xor;
    }

}

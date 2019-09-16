package com.jinku.demo.leetcode;

/**
 * 无重复字符的最长子串
 */
public class Num003 {

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = i - start;
            int index = s.indexOf(s.charAt(i), start);
            if (index < i) {// 有重复元素,则从重复元素开始
                start = index + 1;
            } else {
                count++;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("deabcabcbb"));
    }

}

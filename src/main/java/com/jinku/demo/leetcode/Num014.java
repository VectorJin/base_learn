package com.jinku.demo.leetcode;

/**
 * 最长公共前缀
 */
public class Num014 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int index = 0;
        String result = "";
        while (true) {

            String first = strs[0];
            if (index >= first.length()) {
                return result;
            }
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length()) {
                    return result;
                }

                if (first.charAt(index) != strs[i].charAt(index)) {
                    return result;
                }
            }
            result += first.charAt(index);

            index++;
        }
    }
}

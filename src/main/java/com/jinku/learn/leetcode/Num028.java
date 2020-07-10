package com.jinku.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num028 {

    class Solution {
        /**
         * 暴力解法（双指针）
         *
         * @param haystack
         * @param needle
         * @return
         */
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            int i = 0;
            int j = 0;
            char[] array1 = haystack.toCharArray();
            char[] array2 = needle.toCharArray();

            int preI = 0;
            while (i < haystack.length() && j < needle.length()) {
                if (array1[i] == array2[j]) {
                    if (j == needle.length() - 1) {
                        return i - needle.length() + 1;
                    }
                    i++;
                    j++;
                } else {
                    i = preI;
                    j = 0;
                    preI++;
                }
            }
            return -1;
        }

        /**
         * KMP算法
         *
         * @param haystack
         * @param needle
         * @return
         */
        public int strStr2(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            int i = 0;
            int j = 0;
            char[] array1 = haystack.toCharArray();
            char[] array2 = needle.toCharArray();
            // 关键点next数组
            int[] next = getNext(needle);

            while (i < haystack.length() && j < needle.length()) {
                if (j == -1 || array1[i] == array2[j]) {
                    if (j == needle.length() - 1) {
                        return i - needle.length() + 1;
                    }
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
            }
            return -1;
        }

        /**
         * 通过寻找前缀后缀最长公共元素长度计算next数组
         *
         * @param needle
         * @return
         */
        private int[] getNext(String needle) {
            char[] array = needle.toCharArray();
            int[] next = new int[needle.length()];
            next[0] = -1;
            int k = -1;
            int j = 0;
            while(j < needle.length() - 1) {
                if (k == -1 || array[j] == array[k]) {
                    j++;
                    k++;
                    if (array[j] != array[k]) {
                        next[j] = k;
                    } else {
                        next[j] = next[k];
                    }
                } else {
                    k = next[k];
                }
            }
            return next;
        }

        /**
         * Sunday算法
         *
         * @param haystack
         * @param needle
         * @return
         */
        public int strStr3(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            Map<Character, Integer> map = new HashMap<>();
            char[] array1 = haystack.toCharArray();
            char[] array2 = needle.toCharArray();
            for (int i = 0; i < array2.length; i++) {
                map.put(array2[i], i);
            }
            int i = 0;
            int j = 0;
            while (i < haystack.length() && j < needle.length()) {
                if (array1[i] == array2[j]) {
                    if (j == array2.length - 1) {
                        return i - array2.length + 1;
                    }
                    i++;
                    j++;
                } else {
                    int offset = array2.length - j;
                    if (i + offset > (haystack.length() - 1)) {
                        break;
                    }
                    Integer index = map.get(array1[i + offset]);
                    // 关键点
                    if (index == null) {
                        i = i + (array2.length + 1 - j);
                    } else {
                        i = i + (array2.length - index - j);
                    }
                    j = 0;
                }
            }

            return -1;
        }
    }
}

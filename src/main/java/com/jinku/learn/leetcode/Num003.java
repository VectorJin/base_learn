package com.jinku.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 */
public class Num003 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("  "));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int ans = 0;
        int left = 0;
        Map<Character, Integer> indexMap = new HashMap<>(s.length());
        int i = 0;
        char[] array = s.toCharArray();
        while(i < array.length) {
            Integer index = indexMap.get(array[i]);
            if (index != null) {
                left = Math.max(left, index + 1);
            }
            indexMap.put(array[i], i);
            ans = Math.max(ans, i - left + 1);
            i++;
        }
        return ans;
    }

}

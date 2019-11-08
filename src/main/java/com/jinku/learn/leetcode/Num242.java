package com.jinku.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 */
public class Num242 {

    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            int count = sMap.getOrDefault(c, 0);
            sMap.put(c, count);
        }

        for (char c : t.toCharArray()) {
            int count = tMap.getOrDefault(c, 0);
            tMap.put(c, count);
        }

        if (sMap.size() != tMap.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            Integer count = tMap.get(entry.getKey());
            if (count == null || count.equals(entry.getValue())) {
                return  false;
            }
        }
        return false;
    }
}

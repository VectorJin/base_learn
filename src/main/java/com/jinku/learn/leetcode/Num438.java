package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 找到字符串中所有字母异位词
 */
public class Num438 {

    public static void main(String[] args) {
        System.out.println(findAnagrams("aabaa", "aa"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result =  new ArrayList<>();
        int left = 0;
        int right = 0;
        int sLength = s.length();
        int pLength = p.length();

        Map<Character, Integer> pMap = new HashMap<>(pLength);
        for (Character character : p.toCharArray()) {
            pMap.put(character, pMap.getOrDefault(character, 0) + 1);
        }

        int needMatchKeyCount = pMap.size();
        int matchedKeyCount = 0;

        while (right < sLength) {
            Integer keyCount = pMap.getOrDefault(s.charAt(right), 0);
            if (keyCount == 1) {// 正好满足
                matchedKeyCount++;
            }
            pMap.put(s.charAt(right), keyCount -1);

            // 控制窗口大小
            if (right - left < pLength -1) {
                right++;
                continue;
            }

            if (right - left == pLength -1 && matchedKeyCount == needMatchKeyCount) {
                // 符合条件
                result.add(left);
            }

            keyCount = pMap.get(s.charAt(left));
            if (keyCount != null && keyCount == 0) {
                matchedKeyCount--;
            }
            if (keyCount != null) {
                pMap.put(s.charAt(left), keyCount + 1);
            }
            left++;
            right++;
        }

        return result;
    }
}

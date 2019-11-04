package com.jinku.learn.leetcode;

import java.util.*;

/**
 * 字母异位词分组
 */
public class Num049 {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> item = map.getOrDefault(key, new ArrayList<>());
            if (item.isEmpty()) {
                ans.add(item);
                map.put(key, item);
            }
            item.add(str);
        }

        return ans;
    }
}

package com.jinku.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 */
public class Num013 {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<>(13);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int ans = 0;
        int i = 0;
        int j = 0;
        char[] array = s.toCharArray();

        while (i < array.length && j < array.length) {
            if (j < array.length - 1) {
                Integer v = map.get(Character.toString(array[i]) + Character.toString(array[j + 1]));
                if (v != null) {
                    ans += v;
                    i = i + 2;
                    j = j + 2;
                    continue;
                }
            }
            Integer v = map.get(Character.toString(array[i]));
            ans += v;
            i++;
            j++;

        }
        return ans;
    }
}

package com.jinku.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * “气球” 的最大数量 balloon
 */
public class Num1189 {
    public static int maxNumberOfBalloons(String text) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (Character character : text.toCharArray()) {
            wordMap.put(character.toString(), wordMap.getOrDefault(character.toString(), 0) + 1);
        }
        int b = wordMap.getOrDefault("b", 0);
        int a = wordMap.getOrDefault("a", 0);
        int l = wordMap.getOrDefault("l", 0) / 2;
        int o = wordMap.getOrDefault("o", 0) / 2;
        int n = wordMap.getOrDefault("n", 0);

        return Math.min(Math.min(b > a ? a : b, l > o ? o : l), n);
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko"));
    }
}

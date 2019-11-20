package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 重复的DNA序列
 */
public class Num187 {

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        int[] num = new int[1 << 20];
        int k = (1 << 18) - 1, key = 0;
        for (int i = 0; i < s.length(); i++) {
            key <<= 2;
            key += getValue(s.charAt(i));
            if (i >= 9) {
                if (num[key] == 1) {
                    num[key]++;
                    list.add(s.substring(i - 9, i + 1));
                } else {
                    num[key]++;
                }
                key &= k;
            }
        }
        return list;
    }

    private static int getValue(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                throw new IllegalArgumentException("Illegal character");
        }
    }
}

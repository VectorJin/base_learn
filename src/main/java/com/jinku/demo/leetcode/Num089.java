package com.jinku.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码
 */
public class Num089 {

    public static void main(String[] args) {
        System.out.println(grayCode(4));
    }

    public static List<Integer> grayCode(int n) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}

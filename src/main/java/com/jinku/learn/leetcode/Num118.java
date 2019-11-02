package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
public class Num118 {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();

            for (int j = 0; j <= i ; j++) {
                // 第一个元素
                if (j == 0) {
                    curRow.add(1);
                    continue;
                }
                // 最后一个元素
                if (j == i) {
                    curRow.add(1);
                    continue;
                }
                if (i == 0 || i == 1) {
                    // 前两行没有中间元素
                    continue;
                }
                List<Integer> preRow = ans.get(i - 1);
                // 处理中间元素
                int value = preRow.get(j - 1) + preRow.get(j);
                curRow.add(value);
            }
            ans.add(curRow);
        }
        return ans;
    }
}

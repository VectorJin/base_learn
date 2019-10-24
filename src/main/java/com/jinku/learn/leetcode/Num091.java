package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 解码方法 TODO 0的处理
 */
public class Num091 {

    public static void main(String[] args) {
        System.out.println(numDecodings("128"));
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        return helper(s.toCharArray(), s.length() - 1).size();
    }

    private static List<List<Integer>> helper(char[] array, int n) {
        if (n < 0) {
            return new ArrayList<>();
        }
        int v = array[n] - 48;

        if (n == 0) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> subList = new ArrayList<>();
            subList.add(v);
            list.add(subList);
            return list;
        }

        List<List<Integer>> list = helper(array, n - 1);
        List<List<Integer>> curList = new ArrayList<>();

        for (List<Integer> subList : list) {

            List<Integer> tmpList = new ArrayList<>(subList);
            tmpList.add(v);
            curList.add(tmpList);

            int last = subList.get(subList.size() - 1);
            if (last < 2 || (last == 2 && v <= 6)) {
                tmpList = new ArrayList<>(subList);
                tmpList.remove(tmpList.size() - 1);
                tmpList.add(last * 10 + (v));
                curList.add(tmpList);
            }
        }
        return curList;
    }
}

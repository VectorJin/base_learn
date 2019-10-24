package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 解码方法
 */
public class Num091 {

    public static void main(String[] args) {
        System.out.println(numDecodings2("12201"));
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.startsWith("0")) {
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
            if (v != 0) {
                tmpList.add(v);
                curList.add(tmpList);
            }

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

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public static int numDecodings2(String s) {
        //边界条件
        int length = s.length();
        if (length == 0 || s.charAt(0) == '0') {
            return 0;
        }

        if (length == 1) {
            return 1;
        }

        //初始条件
        int[] dp = new int[length];
        dp[0] = 1;
        if (s.charAt(1) == '0') {
            if (s.charAt(0) != '1' && s.charAt(0) != '2') {
                return 0;
            }
            dp[1] = 1;
        } else {
            if (Character.digit(s.charAt(0), 10) * 10 + Character.digit(s.charAt(1), 10) > 26) {
                dp[1] = 1;
            } else {
                dp[1] = 2;
            }
        }

        // 从i = 2 开始处理
        for (int i = 2; i < length; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0;
                }
                dp[i] = dp[i - 2];
            } else {
                if (s.charAt(i - 1) == '0') {
                    dp[i] = dp[i - 1];
                } else {
                    if (Character.digit(s.charAt(i - 1), 10) * 10 + Character.digit(s.charAt(i), 10) > 26) {
                        dp[i] = dp[i - 1];
                    } else {
                        dp[i] = dp[i - 1] + dp[i - 2];
                    }
                }
            }
        }
        return dp[length - 1];
    }
}

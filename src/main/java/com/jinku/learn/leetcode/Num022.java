package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class Num022 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, "", 0, 0, n);
        return ans;
    }

    private static void helper(List<String> ans, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            ans.add(str);
            return;
        }

        if (open < max) {
            helper(ans, str + "(", open + 1, close, max);
        }
        if (close < open) {
            helper(ans, str + ")", open, close + 1, max);
        }
    }
}

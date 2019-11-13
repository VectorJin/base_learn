package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 */
public class Num017 {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null) {
            return ans;
        }
        String[] map = new String[10];
        map[0] = null;
        map[1] = null;
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";

        for (char c : digits.toCharArray()) {
            List<String> tmp = new ArrayList<>(4 * (ans.size() == 0 ? 1 : ans.size()));
            int v = c - 48;
            String str = map[v];
            if (ans.isEmpty()) {
                for (char c1 : str.toCharArray()) {
                    ans.add(Character.toString(c1));
                }
                continue;
            }
            for (String exist : ans) {
                for (char c1 : str.toCharArray()) {
                    tmp.add(exist + c1);
                }
            }
            ans.clear();
            ans = tmp;
        }

        return ans;
    }
}

package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 分割回文串
 */
public class Num131 {

    public static void main(String[] args) {
        System.out.println(partition("aabb"));
    }

    public static List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int length = s.length();
        for (int len = 1; len <= length; len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
            }
        }
        return partitionHelper(dp, s, 0);
    }

    private static List<List<String>> partitionHelper(boolean[][] dp, String s, int start) {
        //递归出口，空字符串
        if (start == s.length()) {
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            //当前切割后是回文串才考虑
            if (dp[start][i]) {
                String left = s.substring(start, i + 1);
                //遍历后边字符串的所有结果，将当前的字符串加到头部
                for (List<String> l : partitionHelper(dp, s, i + 1)) {
                    l.add(0, left);
                    ans.add(l);
                }
            }
        }
        return ans;
    }

    public static List<List<String>> partition2(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        int length = s.length();
        for (int len = 1; len <= length; len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
            }
        }

        Set<List<String>> ans = new HashSet<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            String str = Character.toString(array[i]);
            Set<List<String>> cur = new HashSet<>();
            if (ans.size() == 0) {
                List<String> item = new ArrayList<>();
                item.add(str);
                cur.add(item);
            } else {
                for (List<String> preItem : ans) {
                    List<String> item = new ArrayList<>(preItem);
                    item.add(str);
                    cur.add(item);

                    String tmpStr = "";
                    for (int z = preItem.size() - 1; z >= 0; z--) {
                        String tmp = preItem.get(z);
                        tmpStr = tmp + tmpStr;
                        if (dp[(i - tmpStr.length())][i]) {
                            item = new ArrayList<>(preItem.subList(0, (z)));
                            item.add(tmpStr + str);
                            cur.add(item);
                        }
                    }

                }
            }
            ans = cur;
        }

        return new ArrayList<>(ans);
    }



    private static boolean isPalindrome(String string) {
        if (string.length() == 1) {
            return true;
        }
        char[] array = string.toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

}

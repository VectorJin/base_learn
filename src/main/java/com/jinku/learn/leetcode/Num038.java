package com.jinku.learn.leetcode;

/**
 * 报数
 */
public class Num038 {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        String ans = "1";
        for (int i = 2;i <= n; i++) {
            String tmp = "";
            int count = 1;
            char pre = 0;
            char[] array = ans.toCharArray();
            for (char c : array) {
                if (pre != 0 && pre != c) {
                    tmp += (String.valueOf(count) + (pre - 48));
                    count = 1;
                } else if (pre == c){
                    count++;
                }
                pre = c;
            }
            tmp += (String.valueOf(count) + (pre - 48));
            ans = tmp;
        }
        return ans;
    }
}

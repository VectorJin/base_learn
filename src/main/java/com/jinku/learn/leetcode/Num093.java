package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 */
public class Num093 {

    List<String> ans = new ArrayList<>();
    String originStr = null;;

    public List<String> restoreIpAddresses(String s) {
        originStr = s;
        helper(0, 0, "");
        return ans;
    }

    public void helper(int index, int count, String currStr) {
        if (count == 4) {
            currStr = currStr.substring(0, currStr.length() - 1);
            ans.add(currStr);
            return;
        }
        if (count > 4) {
            return;
        }

        // 计算出来当前适合的index
        int leftLength = originStr.length() - (currStr.length() - count);
        int minLength = leftLength - (3 * (3 - count));
        if (minLength > 3) {
            // 这种情况不可能
            return;
        }
        int maxLength = leftLength - (3 - count);
        if (maxLength < 0) {
            // 已经没有可用字符
            return;
        }

        minLength = Math.max(1, minLength);
        maxLength = Math.min(3, maxLength);
        for (int i = index + minLength - 1; i <= index + maxLength - 1 && i <= originStr.length() - 1; i++) {
            String tmpStr = originStr.substring(index, i + 1);
            if (tmpStr.startsWith("0") && !tmpStr.equals("0")) {
                break;
            }
            int value = Integer.parseInt(tmpStr);
            if (value > 255) {
                break;
            }
            helper(i + 1, count + 1, currStr + value + ".");
        }
    }
}

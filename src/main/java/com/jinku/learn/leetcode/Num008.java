package com.jinku.learn.leetcode;

/**
 * 字符串转换整数 (atoi)
 */
public class Num008 {

    public static void main(String[] args) {
        System.out.println(myAtoi("   -42"));
    }

    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        boolean negative = false;
        String num = "";
        boolean hasNotEmptyChar = false;
        for (char c : str.toCharArray()) {
            if (' ' == c) {
                if (num.length() == 0 && !hasNotEmptyChar) {
                    continue;
                }
                break;
            }

            if ('+' == c) {
                if (hasNotEmptyChar) {
                    // 不合法
                    break;
                }
                hasNotEmptyChar = true;
                continue;
            }
            if ('-' == c) {
                if (hasNotEmptyChar) {
                    // 不合法
                    break;
                }
                negative = true;
                hasNotEmptyChar = true;
                continue;
            }

            if (c == '0' && num.length() == 0) {
                hasNotEmptyChar = true;
                continue;
            }

            if (c > '9' || c < '0') {
                if (num.length() == 0) {
                    // 不合法
                    break;
                }
                break;
            }
            num += c;
            hasNotEmptyChar = true;
        }

        if (num.length() == 0) {
            return 0;
        }
        if (negative) {
            num = "-" + num;
        }

        if (num.length() > ((Integer.MIN_VALUE + "").length())) {
            if (negative) {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }

        Long value = Long.parseLong(num);
        if (value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (value < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return value.intValue();
    }

}

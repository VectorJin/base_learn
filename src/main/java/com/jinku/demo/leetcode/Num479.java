package com.jinku.demo.leetcode;

import java.util.Stack;

/**
 * Created by jinku on 2018/6/13.
 */
public class Num479 {

    public static int largestPalindrome1(int n) {
        long maxNum = 1;
        for (int i = 1; i <= n; i++) {
            maxNum *= 10;
        }
        // 如何确定步幅
        long step = 1;
        for (int i = 1; i <= (n / 2 + 1); i++) {
            step *= 10;
        }
        if (n % 2 == 0) {
            step /= 10;
        }
        System.out.println("执行步幅" + step);
        maxNum--;
        long maxResult = 0;
        long resultI = -1;
        long resultJ = -1;
        boolean isFound = false;
        long count = 0;
        for (long i = maxNum; i > 0 && !isFound; i--) {
            long tmpCount = 0;
            for (long j = i; j > 0; j--) {
                count++;
                long minValue = Math.min(resultI, resultJ);
                if (i < minValue && j < minValue) {
                    isFound = true;
                    break;
                }

                if (tmpCount > step) {
                    break;
                }
                tmpCount++;

                long temp = i * j;
                // 判断是否为回文结构
                if (isPalindrome1(temp)) {
                    if (temp > maxResult) {
                        maxResult = temp;
                        resultI = i;
                        resultJ = j;
                    }
                    break;
                }
            }
        }
        System.out.println(resultI);
        System.out.println(resultJ);
        System.out.println(maxResult);
        System.out.println("执行循环" + count);
        return Integer.parseInt(String.valueOf(maxResult % 1337));
    }

    public static boolean isPalindrome1(long num) {
        String numStr = String.valueOf(num);
        int numLength = numStr.length();
        int preNum = numLength / 2;
        Stack<Integer> stack = new Stack<Integer>();
        // 前半部分入栈
        for (int i = 0; i < preNum; i++) {
            stack.push(Integer.parseInt(numStr.substring(i, i + 1)));
        }
        // 判断后半部分
        int postStart = preNum;
        if (numLength % 2 != 0) {
            postStart++;
        }

        for (int i = postStart; i < numLength; i++) {
            int curr = Integer.parseInt(numStr.substring(i, i + 1));
            if (curr != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static long getPalindrome(long num) {
        String numStr = num + "";
        StringBuilder numStrBuilder = new StringBuilder(num + "");
        return Long.parseLong(numStr + numStrBuilder.reverse().toString());
    }

    public static int largestPalindrome2(int n) {
        if (n == 1) {
            return 9;
        }
        long maxNum = 1;
        for (int i = 1; i <= n; i++) {
            maxNum *= 10;
        }
        maxNum--;
        long result = 0;
        boolean isFound = false;
        int count = 0;
        for (long i = maxNum; i > maxNum / 10 && !isFound; i--) {
            long palindrome = getPalindrome(i);
            for (long j = maxNum; j > maxNum / 10; j--) {
                count++;
                long tmp = palindrome / j;
                if (tmp > maxNum) {
                    break;
                }
                if (palindrome % j == 0) {
                    // 找到结果
                    result = palindrome;
                    isFound = true;
                    System.out.println(j);
                    System.out.println(tmp);
                    System.out.println(result);
                    break;
                }
            }
        }
        System.out.println("执行循环" + count);
        return Integer.parseInt(String.valueOf(result % 1337));
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        System.out.println(isPalindrome1(12521));
        System.out.println(largestPalindrome2(8));
        long end = System.currentTimeMillis();
        System.out.println((end - begin));
    }
}

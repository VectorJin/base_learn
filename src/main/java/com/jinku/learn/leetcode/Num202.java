package com.jinku.learn.leetcode;

/**
 * 快乐数
 */
public class Num202 {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int slow = n;
        int fast = n;
        while (true) {
            slow = square(slow);
            if (slow == 1) {
                return true;
            }
            fast = square(fast);
            fast = square(fast);
            if (slow == fast) {
                return false;
            }
        }
    }

    public static int square(int n) {
        char[] charArray = String.valueOf(n).toCharArray();
        int[] array = new int[charArray.length];
        int i = 0;
        for (char c : charArray) {
            array[i++] = c - 48;
        }
        int ans = 0;
        for (int num : array) {
            ans += Math.pow(num, 2);
        }
        return ans;
    }
}

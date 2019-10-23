package com.jinku.learn.leetcode;

/**
 * 两数相除
 */
public class Num029 {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 2));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }

        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            }
            return 0;
        }

        int result = 0;
        boolean negative = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            negative = true;
        }

        if (dividend == Integer.MIN_VALUE) {
            if (divisor == Integer.MAX_VALUE) {
                return -1;
            }
        }

        boolean isOver = false;
        if (dividend == Integer.MIN_VALUE) {
            dividend = Integer.MAX_VALUE;
            isOver = true;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (true) {

            if (!isOver && dividend < divisor) {
                break;
            }

            if (isOver) {
                result = result + 1;
                isOver = false;
                dividend = dividend - divisor + 1;
                continue;
            }

            int n = 0;
            while (true) {
                int tmp = divisor << n;
                if (dividend >= tmp && tmp > 0) {
                    n++;
                } else {
                    break;
                }
            }
            n--;
            dividend = dividend - (divisor << n);
            if (n == 0) {
                result = result + (1);
            } else {
                int v = 2 << (n - 1);
                result = result + (v);
            }
        }
        if (negative) {
            return -result;
        }

        return result;
    }
}

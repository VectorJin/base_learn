package com.jinku.learn.leetcode;

/**
 * 螺旋矩阵 II
 */
public class Num059 {

    public static void main(String[] args) {
        System.out.println(generateMatrix(3));
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int total = n * n;
        int index = 1;
        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = n - 1;
        while (index <= total) {
            // 从左到右
            for (int i = l; i <= r; i++) {
                result[t][i] = index++;
            }
            t++;

            // 从上到下
            for (int i = t; i <= b; i++) {
                result[i][r] = index++;
            }
            r--;

            // 从右到左
            for (int i = r; i >= l; i--) {
                result[b][i] = index++;
            }
            b--;

            // 从下到上
            for (int i = b; i >= t; i--) {
                result[i][l] = index++;
            }
            l++;
        }

        return result;
    }
}

package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class Num054 {

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        int total = (right + 1) * (bottom + 1);
        while (result.size() < total) {

            if (left <= right) {
                // 从左到右
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            } else {
                break;
            }

            if (top <= bottom) {
                // 从上到下
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            } else {
                break;
            }

            if (left <= right) {
                // 从右到左
                for (int i = right; i >= left && left <= right; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            } else {
                break;
            }

            if (top <= bottom) {
                // 从下到上
                for (int i = bottom; i >= top && top <= bottom; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            } else {
                break;
            }
        }

        return result;
    }
}

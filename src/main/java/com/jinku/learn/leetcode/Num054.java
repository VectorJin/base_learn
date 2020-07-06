package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class Num054 {

    public static void main(String[] args) {
        System.out.println(spiralOrder2(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
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
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            } else {
                break;
            }

            if (top <= bottom) {
                // 从下到上
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            } else {
                break;
            }
        }

        return result;
    }

    public static int[] spiralOrder2(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        int total = (right + 1) * (bottom + 1);
        int[] result = new int[total];
        int index = -1;
        while (index < total - 1) {
            if (left <= right) {
                // 从左到右
                for (int i = left; i <= right; i++) {
                    result[++index] = matrix[top][i];
                }
                top++;
            } else {
                break;
            }

            if (top <= bottom) {
                // 从上到下
                for (int i = top; i <= bottom; i++) {
                    result[++index] = matrix[i][right];
                }
                right--;
            } else {
                break;
            }

            if (left <= right) {
                // 从右到左
                for (int i = right; i >= left; i--) {
                    result[++index] = matrix[bottom][i];
                }
                bottom--;
            } else {
                break;
            }

            if (top <= bottom) {
                // 从下到上
                for (int i = bottom; i >= top; i--) {
                    result[++index] = matrix[i][left];
                }
                left++;
            } else {
                break;
            }
        }

        return result;
    }
}
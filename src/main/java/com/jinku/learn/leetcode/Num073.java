package com.jinku.learn.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 矩阵置零
 */
public class Num073 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> rowList = new HashSet<>();
        Set<Integer> colList = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowList.add(i);
                    colList.add(j);
                }
            }
        }

        for (int row : rowList) {
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
        }

        for (int col : colList) {
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}

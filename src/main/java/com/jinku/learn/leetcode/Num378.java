package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 有序矩阵中第K小的元素
 */
public class Num378 {

    public int kthSmallest(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<>();
        for (int[] item : matrix) {
            for (int num : item) {
                list.add(num);
            }
        }
        Collections.sort(list);
        return list.get(k -1);
    }
}

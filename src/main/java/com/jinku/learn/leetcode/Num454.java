package com.jinku.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加 II
 */
public class Num454 {

    public static void main(String[] args) {
        System.out.println(fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ans = 0;
        int n = A.length;
        Map<Integer, Integer> abMap = new HashMap<>();
        Map<Integer, Integer> cdMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = A[i] + B[j];
                int count = abMap.getOrDefault(sum, 0);
                abMap.put(sum, count + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = C[i] + D[j];
                int count = cdMap.getOrDefault(sum, 0);
                cdMap.put(sum, count + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : abMap.entrySet()) {
            int value = cdMap.getOrDefault((0 - entry.getKey()), 0);
            ans += (entry.getValue() * value);
        }
        return ans;
    }
}

package com.jinku.demo.sort;

/**
 * Created by jinku on 2018/3/2.
 */
public class QuickSort {

    public int[] sort(int[] origin, int start, int end) {
        if (origin == null || origin.length < 2) {
            return origin;
        }
        if (start >= end) {
            return origin;
        }
        int left = start;
        int right = end;
        int potIndex = left;// 坑的位置
        int base = origin[potIndex];// 基准
        while (left < right) {
            while (left < right) {
                if (origin[right] >= base) {
                    right--;
                } else {
                    origin[potIndex] = origin[right];
                    potIndex = right;
                    break;
                }
            }

            while (left < right) {
                if (origin[left] <= base) {
                    left++;
                } else {
                    origin[potIndex] = origin[left];
                    potIndex = left;
                    break;
                }
            }
        }
        origin[potIndex] = base;
        sort(origin, start, potIndex - 1);
        sort(origin, potIndex + 1, end);
        return origin;
    }
}

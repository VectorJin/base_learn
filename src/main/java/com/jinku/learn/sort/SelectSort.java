package com.jinku.learn.sort;

/**
 * Created by jinku on 2018/3/2.
 * <p/>
 * 选择排序算法
 */
public class SelectSort {

    public int[] sort(int[] origin) {

        for (int i = 0; i < origin.length; i++) {
            // 寻找最小值
            int minValue = origin[i];
            int minIndex = i;
            for (int j = i; j < origin.length; j++) {
                if (origin[j] < minValue) {
                    minValue = origin[j];
                    minIndex = j;
                }
            }
            // 交换位置
            int tmp = origin[i];
            origin[i] = minValue;
            origin[minIndex] = tmp;
        }
        return origin;
    }
}

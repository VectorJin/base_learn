package com.jinku.learn.sort;

/**
 * Created by jinku on 2018/3/4.
 */
public class InsertSort {

    public int[] sort(int[] origin) {
        if (origin == null || origin.length < 2) {
            return origin;
        }

        for (int i = 1; i < origin.length; i++) {
            int tmp = origin[i];
            int j = i;
            while (j > 0 && tmp < origin[j-1] ) {
                origin[j] = origin[j -1];
                j--;
            }
            if (j == 0) {
                origin[j] = tmp;
            }
        }

        return origin;
    }
}

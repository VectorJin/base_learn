package com.jinku.learn.sort;

/**
 * Created by jinku on 2018/3/4.
 */
public class BubbleSort {

    public int[] sort(int[] origin) {

        while (true) {
            boolean isSwap = false;
            int sortCount = 0;
            for (int i = 0; i < origin.length - 1 - sortCount; i++) {
                if (origin[i] > origin[i + 1]) {
                    int tmp = origin[i];
                    origin[i] = origin[i + 1];
                    origin[i + 1] =  tmp;
                    isSwap = true;
                }
            }
            sortCount++;
            if (!isSwap) {
                break;
            }
        }

        return origin;
    }
}

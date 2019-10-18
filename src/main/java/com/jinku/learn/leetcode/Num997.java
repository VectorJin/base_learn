package com.jinku.learn.leetcode;

/**
 * 找到小镇的法官
 */
public class Num997 {

    public int findJudge(int N, int[][] trust) {

        int[][] in_out = new int[N][2];
        for (int[] item : trust) {
            int item1 = item[0];
            int item2 = item[1];
            in_out[item1-1][0] += 1;// 出度
            in_out[item2-1][1] += 1;// 入度
        }
        int index = 1;
        for (int[] item : in_out) {
            if (item[0] == 0 && item[1] == (N - 1)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}

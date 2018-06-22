package com.jinku.demo.leetcode;

/**
 * Created by jinku on 2018/6/14.
 */
public class Num837 {

    public double new21Game(int N, int K, int W) {
        if (K <= 1 && W > 1) {
            // 只能抽一次,概率为1
            return 1.0;
        }
        if (K >= 1 && W <= 1) {
            return 0;
        }

        int curr = 0;
        int overCount = 0;
        int notOverCount = 0;
        while (curr < K) {
            for (int i = 1; i <= W; i++) {

            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}

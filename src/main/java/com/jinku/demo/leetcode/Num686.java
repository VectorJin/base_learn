package com.jinku.demo.leetcode;

/**
 * Created by jinku on 2018/6/14.
 */
public class Num686 {

    public static int repeatedStringMatch(String A, String B) {
        // 先判断是否存在
        if (A == null || B == null) {
            return -1;
        }

        String tmpB = B.replaceAll(A, "#");
        String[] arrayB = tmpB.split("#");
        for (String bStr : arrayB) {
            if (!A.contains(bStr) && arrayB.length != 1) {
                return -1;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(A);
        int count = 1;
        while(true) {
            if (stringBuilder.toString().contains(B)) {
                break;
            }
            if (count > B.length()) {
                return -1;
            }
            stringBuilder.append(A);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abababaaba", "aabaaba"));
    }
}

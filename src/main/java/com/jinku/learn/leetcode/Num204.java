package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinku on 2018/6/13.
 */
public class Num204 {

    public static int countPrimes(int n) {
        Boolean[] primeFlag = new Boolean[n];
        for (int i = 0; i < n; i++) {
            primeFlag[i] = true;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primeFlag[i]) {
                for (int j = i + i; j < n; j = j + i) {
                    primeFlag[j] = false;
                }
                count++;
            }
        }
        return count;
    }

    public static int countPrimes2(int n) {
        int count = 0;
        List<Integer> primesList = new ArrayList<Integer>();
        primesList.add(2);
        primesList.add(3);
        primesList.add(5);
        primesList.add(7);

        for (int i = 2; i < n; i++) {
            boolean isBreak = false;
            for (Integer prime : primesList) {
                if (i != prime && i % prime == 0) {
                    isBreak = true;
                    break;
                }
            }
            if (isBreak) {
                continue;
            }
//            System.out.println(i);
            primesList.add(i);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10000));
    }

}

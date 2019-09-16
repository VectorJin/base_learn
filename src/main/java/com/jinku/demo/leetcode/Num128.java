package com.jinku.demo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 */
public class Num128 {

    public static int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : nums) {
            if (numSet.remove(num)) {
                int longestTmp = 1;
                int numTmp = num;
                while (numSet.remove(numTmp - 1)) {
                    numTmp--;
                }
                longestTmp += (num - numTmp);

                numTmp = num;
                while (numSet.remove(numTmp + 1)) {
                    numTmp++;
                }
                longestTmp += (numTmp - num);

                if (longestTmp > longest) {
                    longest = longestTmp;
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] array = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(array));
    }
}

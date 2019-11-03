package com.jinku.learn.leetcode;

/**
 * 寻找重复数
 */
public class Num287 {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    public static int findDuplicate(int[] nums) {

        int slowIndex = 0;
        int quickIndex = 0;

        while (true) {
            slowIndex = nums[slowIndex];
            quickIndex = nums[nums[quickIndex]];

            if (nums[slowIndex] == nums[quickIndex]) {
                break;
            }
        }
        slowIndex = 0;
        while (true) {
            slowIndex = nums[slowIndex];
            quickIndex = nums[quickIndex];

            if (slowIndex == quickIndex) {
                return slowIndex;
            }
        }
    }

}

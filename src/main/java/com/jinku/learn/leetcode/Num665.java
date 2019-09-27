package com.jinku.learn.leetcode;

/**
 * Created by jinku on 2018/6/13.
 */
public class Num665 {

    public static boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (count > 0) {
                    return false;
                }
                if (i == 1) {
                    nums[i - 1] = nums[i];
                } else {
                    if (nums[i] < nums[i - 2]) {
                        nums[i] = nums[i - 1];
                    } else {
                        nums[i - 1] = nums[i - 2];
                    }
                }
                count++;
            }
        }
        if (count > 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 3};
        boolean result = checkPossibility(nums);
        System.out.println(result);
    }
}

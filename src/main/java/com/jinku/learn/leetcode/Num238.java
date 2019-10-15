package com.jinku.learn.leetcode;

/**
 * 除自身以外数组的乘积
 */
public class Num238 {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int k = 1;
        for (int i = 0;i < nums.length; i++) {
            res[i] = k;
            k *= nums[i];
        }

        k = 1;
        for (int i = nums.length -1;i >= 0;i--) {
            res[i] = k * res[i];
            k *= nums[i];
        }

        return res;
    }


    public int[] productExceptSelf2(int[] nums) {
        return helper(nums, nums.length);
    }

    private int[] helper(int[] nums, int n) {
        if (n == 2) {
            return new int[]{nums[1], nums[0]};
        }

        int[] preArray = helper(nums, n - 1);
        int num = nums[n -1];
        int last = 1;

        int[] result = new int[n];
        for (int i = 0; i < n - 1; i++) {
            result[i] = preArray[i] * num;
            last *= nums[i];
        }
        result[n -1] = last;
        return result;
    }


}

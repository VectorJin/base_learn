package com.jinku.learn.leetcode;

import java.util.Arrays;

/**
 * 最接近的三数之和
 */
public class Num016 {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int sum = target;

        // 先排序
        Arrays.sort(nums);

        // 先找一个基点，然后使用双指针
        int left;
        int right;
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp == target) {
                    return target;
                }

                if (sum == target || Math.abs(tmp - target) < Math.abs(sum - target)) {
                    sum = tmp;
                }

                if (tmp > target) {
                    right--;
                }

                if (tmp < target) {
                    left++;
                }
            }
        }

        return sum;
    }
}

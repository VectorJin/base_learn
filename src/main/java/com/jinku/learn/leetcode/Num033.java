package com.jinku.learn.leetcode;

/**
 * 搜索旋转排序数组
 */
public class Num033 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3}, 1));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }
            return -1;
        }
        return helper(nums, 0, nums.length - 1, target);
    }

    private static int helper(int[] nums, int left, int right, int target) {
        if (left == right) {
            return -1;
        }
        if (right - left == 1) {
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            return -1;
        }

        int mid = (right - left) / 2 + left;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid - 1] == target) {
            return mid - 1;
        }
        if (nums[mid + 1] == target) {
            return mid + 1;
        }

        int leftResult = helper(nums, left, mid, target);
        if (leftResult != -1) {
            return leftResult;
        }
        return helper(nums, mid + 1, right, target);
    }

}

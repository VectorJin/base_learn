package com.jinku.demo.leetcode;

/**
 * 两数之和 II - 输入有序数组
 */
public class Num167 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = numbers.length - 1;

        boolean isSuccess = false;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                isSuccess = true;
                break;
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            }
            if (numbers[left] + numbers[right] < target) {
                left++;
            }
        }
        if (isSuccess) {
            return new int[]{left + 1, right + 1};
        }
        return new int[]{-1, -1};
    }

}

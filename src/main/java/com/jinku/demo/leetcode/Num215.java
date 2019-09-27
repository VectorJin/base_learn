package com.jinku.demo.leetcode;

/**
 * 数组中的第K个最大元素
 */
public class Num215 {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{5, 3, 3, 3, 3, 3, 3, 3, 3}, 1));
    }

    static int result = 0;

    public static int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, k - 1);
        return result;
    }

    private static void quickSort(int[] nums, int left, int right, int k) {
        if (left >= right || right >= nums.length) {
            if (left == k || right == k) {
                result = nums[k];
            }
            return;
        }

        // 找到切分的位置
        int baseIndex = left;
        int baseValue = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > baseValue) {
                baseIndex++;
            }
        }

        if (baseIndex == k) {
            result = baseValue;
        }

        // 交换值，使得基准对象在对应的位置上
        int tmp = nums[baseIndex];
        nums[baseIndex] = baseValue;
        nums[left] = tmp;

        // 将大于基准对象的值放到左边，小于的放到右边
        int i = left;
        int j = baseIndex + 1;
        while (j <= right) {

            if (nums[j] <= baseValue) {
                j++;
                continue;
            }

            if (nums[i] > baseValue) {
                i++;
                continue;
            }

            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j++;
        }

        if (baseIndex > k) {
            quickSort(nums, left, baseIndex - 1, k);
        } else {
            quickSort(nums, baseIndex + 1, right, k);
        }
    }
}

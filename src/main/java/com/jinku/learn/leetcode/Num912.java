package com.jinku.learn.leetcode;

import java.util.PriorityQueue;

/**
 * 升序排列：各类排序算法
 */
public class Num912 {

    /**
     * 冒泡排序
     *
     * @param nums
     * @return
     */
    public int[] sortArray1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }

    /**
     * 选择排序
     *
     * @param nums
     * @return
     */
    public int[] sortArray2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            int min = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    minIndex = j;
                    min = nums[j];
                }
            }
            if (minIndex != i) {
                int tmp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = tmp;
            }
        }
        return nums;
    }

    /**
     * 插入排序
     *
     * @param nums
     * @return
     */
    public int[] sortArray3(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int curr = nums[i + 1];
            int j = i;
            for (; j >= 0; j--) {
                if (curr <= nums[j]) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = curr;
        }
        return nums;
    }

    /**
     * 快速排序
     *
     * @param nums
     * @return
     */
    public int[] sortArray4(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int baseValue = nums[left];
        int baseIndex = left;
        int i = left + 1;
        int j = right;

        while (i <= j) {
            while (i <= j) {
                if (nums[j] < baseValue) {
                    nums[i - 1] = nums[j];
                    baseIndex = j;
                    j--;
                    break;
                }
                j--;
            }
            while (i <= j) {
                if (nums[i] > baseValue) {
                    nums[j + 1] = nums[i];
                    baseIndex = i;
                    i++;
                    break;
                }
                i++;
            }
        }
        nums[baseIndex] = baseValue;
        quickSort(nums, left, baseIndex - 1);
        quickSort(nums, baseIndex + 1, right);
    }

    /**
     * 归并排序
     *
     * @param nums
     * @return
     */
    public int[] sortArray5(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int[] mergeSort(int[] nums, int left, int right) {
        int[] mergedResult = new int[right - left + 1];
        // 边界条件
        if (left == right) {
            mergedResult[0] = nums[left];
            return mergedResult;
        }

        // 拆分
        int baseIndex = (right - left) / 2 + left;
        int[] leftResult = mergeSort(nums, left, baseIndex);
        int[] rightResult = mergeSort(nums, baseIndex + 1, right);

        // 合并结果
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < leftResult.length || j < rightResult.length) {
            if (i >= leftResult.length || leftResult[i] > rightResult[j]) {
                mergedResult[index++] = rightResult[j++];
            }
            if (j >= rightResult.length || leftResult[i] <= rightResult[j]) {
                mergedResult[index++] = leftResult[i++];
            }
        }

        return mergedResult;
    }

    /**
     * 堆排序
     *
     * @param nums
     * @return
     */
    public int[] sortArray6(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length);
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = queue.poll();
        }
        return nums;
    }
}

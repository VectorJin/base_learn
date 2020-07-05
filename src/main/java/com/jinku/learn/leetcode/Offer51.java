package com.jinku.learn.leetcode;

/**
 * 数组中的逆序对
 */
public class Offer51 {

    int ans = 0;

    /**
     * 归并排序解法
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        helper(nums, 0, nums.length - 1);
        return ans;
    }

    private int[] helper(int[] nums, int left, int right) {
        if (left >= right) {
            return new int[]{nums[left]};
        }
        int mid = (right - left) / 2 + left;
        int[] leftArray = helper(nums, left, mid);
        int[] rightArray = helper(nums, mid + 1, right);
        return merge(leftArray, rightArray);
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int[] mergedArray = new int[leftArray.length + rightArray.length];
        int leftI = 0;
        int rightI = 0;
        int index = 0;
        while (leftI < leftArray.length || rightI < rightArray.length) {
            if (leftI >= leftArray.length) {
                mergedArray[index++] = rightArray[rightI++];
                continue;
            }
            if (rightI >= rightArray.length) {
                mergedArray[index++] = leftArray[leftI++];
                continue;
            }
            if (leftArray[leftI] > rightArray[rightI]) {
                // 关键点
                ans += (leftArray.length - leftI);
                mergedArray[index++] = rightArray[rightI++];
                continue;
            }
            if (leftArray[leftI] <= rightArray[rightI]) {
                mergedArray[index++] = leftArray[leftI++];
            }
        }

        return mergedArray;
    }

}

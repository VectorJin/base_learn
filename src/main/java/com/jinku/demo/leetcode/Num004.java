package com.jinku.demo.leetcode;

/**
 * 寻找两个有序数组的中位数
 */
public class Num004 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            if (nums2 == null || nums2.length == 0) {
                return 0;
            }

            if (nums2.length % 2 == 0) {
                return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
            }
            return nums2[nums2.length / 2];
        }
        if (nums2 == null || nums2.length == 0) {
            if (nums1.length % 2 == 0) {
                return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0;
            }
            return nums1[nums1.length / 2];
        }

        int length = nums1.length + nums2.length;
        int targetIndex = length / 2;

        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        int preTargetValue = 0;
        int targetValue = 0;

        while (index <= targetIndex) {

            int currValue = 0;

            if (leftIndex >= nums1.length) {

                currValue = nums2[rightIndex];
                rightIndex++;

            } else if (rightIndex >= nums2.length) {

                currValue = nums1[leftIndex];
                leftIndex++;

            } else {
                if (nums1[leftIndex] <= nums2[rightIndex]) {
                    currValue = nums1[leftIndex];
                    leftIndex++;
                } else if (nums1[leftIndex] > nums2[rightIndex]) {
                    currValue = nums2[rightIndex];
                    rightIndex++;
                }
            }

            if (index == targetIndex) {
                targetValue = currValue;
            } else {
                preTargetValue = currValue;
            }
            index++;
        }

        if (length % 2 == 0) {
            return (preTargetValue + targetValue) / 2.0;
        }
        return targetValue;
    }
}

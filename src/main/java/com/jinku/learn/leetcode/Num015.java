package com.jinku.learn.leetcode;

import java.util.*;

/**
 * 三数之和
 */
public class Num015 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        long end = System.currentTimeMillis();
        System.out.println((end - start));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int currValue = nums[i];
            if (currValue > 0) {
                break;
            }
            if (i > 0 && currValue == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            long preLeft = Integer.MAX_VALUE + 1L;

            while (left < right) {
                if (nums[left] + nums[right] + currValue == 0) {

                    if (nums[left] != preLeft) {
                        List<Integer> item = new ArrayList<>();
                        item.add(currValue);
                        item.add(nums[left]);
                        item.add(nums[right]);
                        result.add(item);
                        preLeft = nums[left];
                    }

                    left++;
                    right--;
                }
                if (nums[left] + nums[right] + currValue > 0) {
                    right--;
                }
                if (nums[left] + nums[right] + currValue < 0) {
                    left++;
                }
            }
        }
        return result;
    }
}

package com.jinku.learn.leetcode;

/**
 * 删除排序数组中的重复项
 */
public class Num026 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        int pre = nums[0] - 1;
        for (int num : nums) {
            if (pre == num) {// 当前元素与前一元素相同
                continue;
            }
            nums[index] = num;
            pre = num;
            index++;
        }
        return index;
    }

}

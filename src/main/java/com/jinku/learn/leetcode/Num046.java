package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class Num046 {

    public List<List<Integer>> permute(int[] nums) {
        return helper(nums, nums.length - 1);
    }

    private List<List<Integer>> helper(int[] nums, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0) {
            List<Integer> tmpItem = new ArrayList<>();
            tmpItem.add(nums[0]);
            result.add(tmpItem);
            return result;
        }

        List<List<Integer>> preList = helper(nums, n - 1);
        int num = nums[n];
        for (List<Integer> listItem : preList) {
            for (int i = 0; i <= listItem.size(); i++) {
                List<Integer> newList = new ArrayList<>(listItem);
                newList.add(i, num);
                preList.add(newList);
            }
        }
        return result;
    }

}

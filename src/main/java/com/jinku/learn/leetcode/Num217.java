package com.jinku.learn.leetcode;

import java.util.HashSet;

/**
 * 存在重复元素
 */
public class Num217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;
    }
}

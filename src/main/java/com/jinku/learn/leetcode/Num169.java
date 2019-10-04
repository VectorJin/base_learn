package com.jinku.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 求众数
 */
public class Num169 {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (nums.length / 2)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public int majorityElement2(int[] nums) {
        int result = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                result = num;
            }
            if (count == 0 || num == result) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}

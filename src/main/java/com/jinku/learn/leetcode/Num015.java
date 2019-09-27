package com.jinku.learn.leetcode;

import java.util.*;

/**
 * 三数之和
 */
public class Num015 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));
        long end = System.currentTimeMillis();
        System.out.println((end - start));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;

        int newSize = 0;
        Map<Integer, List<Integer>> value2IndexMap = new HashMap<>();
        Map<Integer, Integer> removedIndexMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int value = nums[i];
            List<Integer> indexList = value2IndexMap.getOrDefault(value, new ArrayList<>());
            if (value != 0 && indexList.size() >= 2) {
                // 已经有两个一样的非零，就不需要了
                removedIndexMap.put(i, null);
                continue;
            }
            if (value == 0 && indexList.size() >= 3) {
                // 已经有三个0，就不需要了
                removedIndexMap.put(i, null);
                continue;
            }
            newSize++;
            value2IndexMap.put(value, indexList);
            indexList.add(i);
        }

        value2IndexMap.clear();
        int[] newNums = new int[newSize];
        int newIndex = 0;
        for (int i = 0; i < length; i++) {
            int value = nums[i];
            if (removedIndexMap.containsKey(i)) {
                continue;
            }
            newNums[newIndex] = value;

            List<Integer> indexList = value2IndexMap.getOrDefault(value, new ArrayList<>());
            value2IndexMap.put(value, indexList);
            indexList.add(newIndex);
            newIndex++;
        }

        Map<String, Integer> isExistMap = new HashMap<>(newSize / 3 + 1);

        // 先两两合并
        for (int i = 0; i < newSize; i++) {
            for (int j = i + 1; j < newSize; j++) {
                int needValue = 0 - (newNums[i] + newNums[j]);
                List<Integer> indexList = value2IndexMap.get(needValue);
                if (indexList == null) {
                    continue;
                }

                for (int index : indexList) {
                    if (index != i && index != j) {
                        List<Integer> item = new ArrayList<>();
                        item.add(newNums[i]);
                        item.add(newNums[j]);
                        item.add(newNums[index]);
                        Collections.sort(item);
                        String key = "";
                        for (int v : item) {
                            key += v;
                        }
                        if (!isExistMap.containsKey(key)) {
                            result.add(item);
                            isExistMap.put(key, null);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {

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

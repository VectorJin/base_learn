package com.jinku.learn.leetcode;

import java.util.*;

/**
 * 组合总和
 */
public class Num039 {

    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates== null || candidates.length == 0) {
            return ans;
        }
        for (int candidate : candidates) {
            helper(candidates, target, candidate, ans, new ArrayList<>());
        }

        return ans;
    }

    public static void helper(int[] candidates, int target, int candidate, List<List<Integer>> ans, List<Integer> currList) {

        // 依次递增规则，保证组合唯一
        if (!currList.isEmpty() && currList.get(currList.size() -1) > candidate) {
            currList.clear();
            return;
        }

        if (target == candidate) {
            currList.add(candidate);
            ans.add(currList);
            return;
        }
        if (target < candidate) {
            currList.clear();
            return;
        }

        currList.add(candidate);
        target = target - candidate;

        for (int newCandidate : candidates) {
            List<Integer> newCurrList = new ArrayList<>(currList);
            helper(candidates, target, newCandidate, ans, newCurrList);
        }
    }

}

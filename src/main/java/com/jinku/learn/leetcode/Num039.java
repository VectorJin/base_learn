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
        Set<List<Integer>> ansSet = new HashSet<>();
        for (int candidate : candidates) {
            helper(candidates, target, candidate, ansSet, new ArrayList<>());
        }
        // 去重
        for (List<Integer> list : ansSet) {
            ans.add(list);
        }

        return ans;
    }

    public static void helper(int[] candidates, int target, int candidate, Set<List<Integer>> ans, List<Integer> currList) {
        if (target == candidate) {
            currList.add(candidate);
            Collections.sort(currList);
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

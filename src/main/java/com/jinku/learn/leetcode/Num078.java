package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 子集
 */
public class Num078 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            Iterator<List<Integer>> resultIterator = result.iterator();
            List<List<Integer>> tmpResult = new ArrayList<>();
            while (resultIterator.hasNext()) {
                List<Integer> newSubList = new ArrayList<>(resultIterator.next());
                newSubList.add(num);
                tmpResult.add(newSubList);
            }
            result.addAll(tmpResult);
        }
        return result;
    }
}

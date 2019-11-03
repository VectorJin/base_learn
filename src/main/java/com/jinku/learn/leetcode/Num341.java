package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 扁平化嵌套列表迭代器
 */
public class Num341 {

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        List<Integer> innerList;
        int index = 0;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.innerList = new ArrayList<>();
            // 遍历nestedList 生成 innerList
            iterateList(innerList, nestedList);
        }

        @Override
        public Integer next() {
            return innerList.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < innerList.size();
        }

        private void iterateList(List<Integer> innerList, List<NestedInteger> nestedList) {
            if (nestedList == null || nestedList.isEmpty()) {
                return;
            }
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    innerList.add(nestedInteger.getInteger());
                } else {
                    iterateList(innerList, nestedInteger.getList());
                }
            }

        }
    }
}

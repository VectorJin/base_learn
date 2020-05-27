package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 合并区间
 */
public class Num056 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        List<Integer> indexList = new ArrayList<>(intervals.length);

        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            boolean merged = false;

            Iterator<Integer> indexIterator = indexList.iterator();
            while(indexIterator.hasNext()) {
                int index = indexIterator.next();
                int oLeft = intervals[index][0];
                int oRight = intervals[index][1];

                if (left >= oLeft && right <= oRight) {
                    // 在现有的区间内
                    merged = true;
                    break;
                } else if (right < oLeft || left > oRight) {
                    // 与现有的区间内不交叉
                } else {
                    // 与现有区间交叉的情况，取最大边界
                    left = Math.min(left, oLeft);
                    right = Math.max(right, oRight);
                    indexIterator.remove();
                }
            }
            if (!merged) {
                intervals[i][0] = left;
                intervals[i][1] = right;
                indexList.add(i);
            }
        }

        int[][] ans = new int[indexList.size()][2];
        int i = 0;
        for (int index : indexList) {
            ans[i][0] = intervals[index][0];
            ans[i][1] = intervals[index][1];
            i++;
        }
        return ans;
    }
}

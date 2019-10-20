package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程表 II
 */
public class Num210 {

    public static void main(String[] args) {
        System.out.println(findOrder(2, new int[][]{{0, 1}, {1, 0}}));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] inDegrees = new int[numCourses];
        List<Integer>[] succeedList = new ArrayList[numCourses];
        for (int[] item : prerequisites) {
            inDegrees[item[0]]++;
            if (succeedList[item[1]] == null) {
                succeedList[item[1]] = new ArrayList<>();
            }
            succeedList[item[1]].add(item[0]);
        }

        int[] flag = new int[numCourses];
        boolean found;
        for (int i = 0; i < numCourses; i++) {
            found = false;
            // 找出一个入度=0的节点
            for (int j = 0; j < numCourses; j++) {
                if (flag[j] == 1) {
                    continue;
                }

                if (inDegrees[j] == 0) {
                    result[i] = j;
                    flag[j] = 1;

                    // 后继结点的入度减一
                    if (succeedList[j] != null) {
                        for (int succeed : succeedList[j]) {
                            inDegrees[succeed]--;
                        }
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                return new int[]{};
            }
        }

        return result;
    }
}

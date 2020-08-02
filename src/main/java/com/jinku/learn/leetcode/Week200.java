package com.jinku.learn.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 第 200 场周赛
 */
public class Week200 {

    class Solution1 {
        public int countGoodTriplets(int[] arr, int a, int b, int c) {
            int ans = 0;
            int length = arr.length;

            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    for (int k = j + 1; k < length; k++) {
                        if (Math.abs(arr[i] - arr[j]) > a) {
                            continue;
                        }
                        if (Math.abs(arr[j] - arr[k]) > b) {
                            continue;
                        }
                        if (Math.abs(arr[i] - arr[k]) > c) {
                            continue;
                        }
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

    class Solution2 {
        public int getWinner(int[] arr, int k) {
            int max = Integer.MIN_VALUE;
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
                if (i > 1) {
                    queue.add(arr[i]);
                }
            }
            if (queue.size() == 0) {
                return max;
            }

            int num1 = arr[0];
            int num2 = arr[1];
            Integer preWinner = null;
            int winnerTimes = 0;
            while (true) {
                // 当前最大值
                if (num1 == max) {
                    return max;
                }
                int failed;
                int winner;
                // 判断获胜者
                if (num1 > num2) {
                    winner = num1;
                    failed = num2;
                } else {
                    winner = num2;
                    failed = num2;
                }

                if (preWinner != null && preWinner == winner) {
                    winnerTimes++;
                } else {
                    winnerTimes = 1;
                }
                preWinner = winner;
                // 连续k次赢家
                if (winnerTimes >= k) {
                    return winner;
                }
                // 失败者需要放到队列最后
                queue.add(failed);
                num1 = winner;
                num2 = queue.poll();
            }
        }
    }

    class Solution3 {
        public int minSwaps(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int ans = 0;
            List<NodeInfo> notMatchedRows = new ArrayList<>();
            List<NodeInfo> matchedRows = new ArrayList<>();
            // 找出所有不满足的行
            for (int i = 0; i < m; i++) {
                for (int j = n - 1; j > i; j--) {
                    if (grid[i][j] == 1) {
                        notMatchedRows.add(new NodeInfo(i, true, m - i - 1, n - j - 1));
                        break;
                    }
                }
                int j = n - 1;
                for (; j >= 0; j--) {
                    if (grid[i][j] == 1) {
                        break;
                    }
                }
                // 满足条件的行
                matchedRows.add(new NodeInfo(i, false, m - i - 1, m - j - 1));
            }

            // 匹配不满足的行和满足的行
            if (notMatchedRows.size() != matchedRows.size()) {
                return -1;
            }

            return ans;
        }

        class NodeInfo {
            int row;// 所在行
            boolean needReversed;//是否需要翻转
            int needZeros;// 需要0的个数
            int providedZeros;// 提供0的个数

            NodeInfo(int row, boolean needReversed, int needZeros, int providedZeros) {
                this.row = row;
                this.needReversed = needReversed;
                this.needZeros = needZeros;
                this.providedZeros = providedZeros;
            }
        }
    }

}

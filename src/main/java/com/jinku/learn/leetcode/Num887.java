package com.jinku.learn.leetcode;

import org.junit.Test;

/**
 * 鸡蛋掉落
 */
public class Num887 {

    int[][] store;

    /**
     * 鸡蛋掉落
     *
     * @param K : 鸡蛋数量
     * @param N : 楼层数
     * @return
     */
    public int superEggDrop(int K, int N) {
        store = new int[K + 1][N + 1];
        return helper(K, N);
    }

    /**
     * 递归解法 (容易栈溢出)
     *
     * @param K
     * @param N
     * @return
     */
    public int helper(int K, int N) {
        if (K <= 1 || N <= 1) {
            return N;
        }
        if (store[K][N] != 0) {
            return store[K][N];
        }
        int ans = Integer.MAX_VALUE;
        // 每个楼层进行尝试
        for (int i = 1; i <= N; i++) {
            // 分 碎 和 不碎 两种
            ans = Math.min(ans, Math.max(helper(K - 1, i - 1), helper(K, N - i)) + 1);
        }
        store[K][N] = ans;
        return ans;
    }

    /**
     * 鸡蛋掉落 (动态规划)
     *
     * @param K : 鸡蛋数量
     * @param N : 楼层数
     * @return
     */
    public int superEggDrop2(int K, int N) {
        store = new int[K + 1][N + 1];

        for (int i = 1; i <= K; i++) {//鸡蛋数量
            for (int j = 1; j <= N; j++) {//楼层数量
                if (store[i][j] != 0) {
                    continue;
                }
                if (i== 1) {
                    store[i][j] = j;
                    continue;
                }
                if (j == 1) {
                    store[i][j] = 1;
                    continue;
                }
                int ans = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    ans = Math.min(ans, (Math.max(store[i - 1][k - 1], store[i][j - k]) + 1));
                }
                store[i][j] = ans;
            }
        }
        return store[K][N];
    }

    @Test
    public void test() {
        System.out.println(superEggDrop2(8, 10000));
    }
}

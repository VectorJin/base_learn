package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 迷路的机器人
 */
public class Num0802 {

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 0}};
        System.out.println(pathWithObstacles(obstacleGrid));
    }

    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new ArrayList<>();
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return new ArrayList<>();
        }
        boolean[][] visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        helper(res, 0, 0, obstacleGrid, visited);

        return res;
    }

    /**
     * 只能向下或向右移动
     *
     * @param res
     * @param x            : 行
     * @param y            : 列
     * @param obstacleGrid
     * @param visited
     */
    public static boolean helper(List<List<Integer>> res,
                              int x, int y, int[][] obstacleGrid, boolean[][] visited) {
        int xLength = obstacleGrid.length;
        int yLength = obstacleGrid[0].length;

        if (x >= (xLength) || y >= (yLength) || obstacleGrid[x][y] == 1 || visited[x][y]) {
            return false;
        }

        res.add(Arrays.asList(x, y));
        if (x == xLength - 1 && y == yLength -1) {
            return true;
        }

        visited[x][y] = true;

        if (helper(res, x, y + 1, obstacleGrid, visited) || helper(res, x + 1, y, obstacleGrid, visited)) {
            return true;
        }

        res.remove(res.size() -1);
        return false;
    }
}

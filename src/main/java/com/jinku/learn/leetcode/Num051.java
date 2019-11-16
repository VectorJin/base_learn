package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后
 */
public class Num051 {

    public static void main(String[] args) {
        System.out.println(solveNQueens(11));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        helper(0, n, new ArrayList<>(), ans, null);
        return ans;
    }

    private static void helper(int row, int n, List<Integer> selectedList, List<List<String>> ans, List<String> currBranch) {
        if (row == n) {
            // 此分支完成
            ans.add(currBranch);
            return;
        }

        List<Integer> canSelectList = getCanSelect(selectedList, n, row);
        if (canSelectList.isEmpty()) {
            // 此分支不可完成
            return;
        }
        for (Integer select : canSelectList) {

            List<String> childBranch = new ArrayList<>();
            if (currBranch != null) {
                childBranch.addAll(currBranch);
            }
            // 拼接当前row的结果
            String rowStr = "";
            for (int i = 0; i < n; i++) {
                if (i == select) {
                    rowStr += "Q";
                } else {
                    rowStr += ".";
                }
            }
            childBranch.add(rowStr);

            selectedList.add(select);
            helper(row + 1, n, selectedList, ans, childBranch);
            selectedList.remove(select);
        }
    }

    private static List<Integer> getCanSelect(List<Integer> selectedList, int n, int row) {
        List<Integer> canSelectList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean canSelect = true;
            for (int j = 0; j < selectedList.size(); j++) {
                int selected = selectedList.get(j);
                if (i == selected) {// 同列不可选
                    canSelect = false;
                    break;
                }
                int diff = row - j;

                if (i == (selected + diff)) {// 右45度不可选
                    canSelect = false;
                    break;
                }
                if (i == (selected - diff)) {// 左45度不可选
                    canSelect = false;
                    break;
                }
            }
            if (canSelect) {
                canSelectList.add(i);
            }
        }
        return canSelectList;
    }
}

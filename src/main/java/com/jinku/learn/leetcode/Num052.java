package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后 II
 */
public class Num052 {

    public static void main(String[] args) {
        System.out.println(totalNQueens(8));
    }

    public static int totalNQueens(int n) {
        List<Integer> ans = new ArrayList<>();
        helper(0, n, new ArrayList<>(), ans);
        return ans.size();
    }

    private static void helper(int row, int n, List<Integer> selectedList, List<Integer> ans) {
        if (row == n) {
            // 此分支完成
            ans.add(1);
            return;
        }

        List<Integer> canSelectList = getCanSelect(selectedList, n, row);
        if (canSelectList.isEmpty()) {
            // 此分支不可完成
            return;
        }
        for (Integer select : canSelectList) {
            selectedList.add(select);
            helper(row + 1, n, selectedList, ans);
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

                if (i == (selected - diff)) {// 左45度不可选
                    canSelect = false;
                    break;
                }

                if (i == (selected + diff)) {// 右45度不可选
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

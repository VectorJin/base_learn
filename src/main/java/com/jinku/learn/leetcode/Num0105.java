package com.jinku.learn.leetcode;

/**
 * 一次编辑
 */
public class Num0105 {

    public static void main(String[] args) {
        System.out.println(oneEditAway("pale", "pele33"));
    }

    public static boolean oneEditAway(String first, String second) {
        if (first.equals(second)) {
            return true;
        }

        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        int i = 0, j = 0;
        boolean add = false;
        boolean remove = false;
        boolean replace = false;
        int max = first.length();
        if (first.length() > second.length()) {
            remove = true;
        }
        if (first.length() < second.length()) {
            add = true;
            max = second.length();
        }
        if (first.length() == second.length()) {
            replace = true;
        }
        int opCount = 0;
        while (i < max && j < max && opCount < 2) {

            if (i < first.length() && j < second.length()) {
                if (first.substring(i, i + 1).equals(second.substring(j, j + 1))) {
                    i++;
                    j++;
                    continue;
                }
            }

            if (add) {
                j++;
                opCount++;
            }

            if (remove) {
                i++;
                opCount++;
            }

            if (replace) {
                i++;
                j++;
                opCount++;
            }
        }

        return opCount < 2;
    }

}

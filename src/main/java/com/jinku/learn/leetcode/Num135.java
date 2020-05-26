package com.jinku.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 分发糖果
 */
public class Num135 {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }
        int[] candies = new int[ratings.length];

        // 找到所有的大小大模式中所有小的index
        List<Integer> minIndex = new ArrayList<>();
        for (int i = 0; i < ratings.length; i++) {
            if (i == 0 && ratings[i + 1] >= ratings[i]) {
                minIndex.add(i);
            } else if (i == ratings.length - 1 && ratings[i] <= ratings[i - 1]) {
                minIndex.add(i);
            } else if (i > 0 && i < ratings.length - 1 && ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]) {
                minIndex.add(i);
            } else {
                continue;
            }
            candies[i] = 1;
        }
        // 以小的index为中心向两边扩散
        for (int index : minIndex) {
            // 向左扩散
            int lIndex = index;
            while (lIndex > 0) {
                if (ratings[lIndex - 1] > ratings[lIndex] && (lIndex - 1 == 0 || ratings[lIndex - 2] >= ratings[lIndex - 1])) {
                    candies[lIndex - 1] = candies[lIndex] + 1;
                } else {
                    break;
                }
                lIndex--;
            }
            // 向右扩散
            int rIndex = index;
            while (rIndex < ratings.length - 1) {
                if (ratings[rIndex + 1] > ratings[rIndex] && (rIndex + 1 == ratings.length - 1 || ratings[rIndex + 2] >= ratings[rIndex + 1])) {
                    candies[rIndex + 1] = candies[rIndex] + 1;
                } else {
                    break;
                }
                rIndex++;
            }
        }
        // 对还未分发糖果的进行处理
        for (int i = 0 ; i < candies.length; i++) {
            if (candies[i] != 0) {
                continue;
            }
            if (i == 0 || i == candies.length -1) {
                candies[i] = 1;
            } else {
                candies[i] = Math.max(candies[i - 1], candies[i + 1]) + 1;
            }
        }
        int ans = 0;
        for (int candy : candies) {
            ans += candy;
        }
        return ans;
    }

    public int candy2(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }
        int[] candies = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            candies[i] = 1;
        }
        // 从左到右应用规则
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i -1] + 1;
            }
        }
        // 从右向左应用规则
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < candies.length; i++) {
            ans += candies[i];
        }
        return ans;
    }
}

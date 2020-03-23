package com.jinku.learn.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 马戏团人塔
 */
public class Num1708 {

    public int bestSeqAtIndex(int[] height, int[] weight) {
        if (height == null || weight == null) {
            return 0;
        }
        int res = 0;
        Person[] persons = new Person[height.length];
        for (int i = 0; i < height.length; i++) {
            persons[i] = new Person(height[i], weight[i]);
        }
        Arrays.sort(persons, (c1, c2) -> {
            if (c1.height.equals(c2.height)) {
                return c2.weight.compareTo(c1.weight);
            }
            return c1.height.compareTo(c2.height);
        });

        int[] tails = new int[persons.length];
        for (Person person : persons) {
            // 使用二分查找找到位置
            int i = 0;
            int j = res;
            while (i < j) {
                int m = (j - i) / 2 + i;
                if (person.weight <= tails[m]) {
                    j = m;
                }
                if (person.weight > tails[m]) {
                    i = m + 1;
                }
            }
            tails[i] = person.weight;
            if (j == res) {
                res++;
            }
        }

        return res;
    }

    public static class Person {
        Integer height;
        Integer weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

}

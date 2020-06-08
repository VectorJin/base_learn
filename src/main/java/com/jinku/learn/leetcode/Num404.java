package com.jinku.learn.leetcode;

import org.junit.Test;

/**
 * 字典序的第K小数字
 */
public class Num404 {

    public int findKthNumber(int n, int k) {
        long index = 1;
        long parentValue = 0;
        long currNumber = 1;

        while (true) {
            if (currNumber == 10) {
                // 转向父节点的兄弟节点
                currNumber = parentValue % 10 + 1;
                int pLength = ("" + parentValue).length();
                if (pLength == 1) {
                    parentValue = 0;
                } else {
                    parentValue = parentValue / 10;
                }
                continue;
            }
            long curValue = parentValue * 10 + currNumber;
            if (index == k) {
                return (int) curValue;
            }
            index++;

            // 还有子节点
            if (curValue * 10 <= n) {
                parentValue = parentValue * 10 + currNumber;
                currNumber = 0;
            } else {
                // 没有子节点，转向兄弟节点
                if (currNumber < 9 && curValue + 1 <= n) {
                    currNumber++;
                } else {
                    // 转向父节点的兄弟节点
                    currNumber = parentValue % 10 + 1;
                    int pLength = ("" + parentValue).length();
                    if (pLength == 1) {
                        parentValue = 0;
                    } else {
                        parentValue = parentValue / 10;
                    }
                }
            }
        }
    }

    public int findKthNumber2(int n, int k) {
        int curr = 1;
        k -= 1;
        while (k > 0) {
            long step = calStep(n, curr, curr + 1);

            if (k < step) {//在这个范围内
                curr *= 10;//向下移动一层
                k--;
            } else {//移动相邻的下一个节点
                k -= step;
                curr = curr + 1;
            }

        }
        return curr;
    }

    private long calStep(int n, long n1, long n2) {
        int ans = 0;
        while (n1 <= n) {
            ans += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(findKthNumber2(209, 6));
        System.out.println(findKthNumber(681692778, 351251360));
    }
}

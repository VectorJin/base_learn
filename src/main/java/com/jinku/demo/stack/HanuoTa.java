package com.jinku.demo.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinku on 2018/5/25.
 * 经典汉诺塔:增加限制只能相邻柱子直接传递盘子
 */
public class HanuoTa {

    private static List<Integer> oneList = new ArrayList<Integer>();
    private static List<Integer> twoList = new ArrayList<Integer>();
    private static List<Integer> thirdList = new ArrayList<Integer>();

    private static List<List<String>> allOpList = new ArrayList<List<String>>();
    private static List<String> tempList = new ArrayList<String>();

    public static void operate(int preFrom, int preTo) {
        if (oneList.size() == 0 && twoList.size() == 0) {
            // 结束标志
            // 记录路径
            List<String> list = new ArrayList<String>();
            list.addAll(tempList);
            allOpList.add(list);
            return;
        }

        // 先选出挪盘子的柱子
        int minFirst = getMin(oneList);
        int minSecond = getMin(twoList);
        int minThird = getMin(thirdList);

        if (minFirst < minSecond && (preFrom != 2 || preTo != 1)) {
            int min = oneList.remove(0);
            twoList.add(0, min);
            tempList.add("1----->2");
            operate(1, 2);
            tempList.clear();
        }

        if (minThird < minSecond && (preFrom != 2 || preTo != 3)) {
            int min = thirdList.remove(0);
            twoList.add(0, min);
            tempList.add("3----->2");
            operate(3, 2);
            tempList.clear();
        }

        if (minSecond < minFirst && (preFrom != 1 || preTo != 2)) {
            int min = twoList.remove(0);
            oneList.add(0, min);
            tempList.add("2----->1");
            operate(2, 1);
            tempList.clear();
        }

        if (minSecond < minThird && (preFrom != 3 || preTo != 2)) {
            int min = twoList.remove(0);
            thirdList.add(0, min);
            tempList.add("2----->3");
            operate(2, 3);
            tempList.clear();
        }
    }

    private static Integer getMin(List<Integer> list) {
        if (list.size() == 0) {
            return Integer.MAX_VALUE;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int N = 2;
        for (int i = 1; i <= N; i++) {
            oneList.add(i);
        }
        operate(-1, -1);
        System.out.println("执行路径共" + allOpList.size() + "条");
        for (List<String> opList : allOpList) {
            System.out.println("该执行路径共[" + opList.size() + "]步");
            for (String value : opList) {
                System.out.println(value);
            }
        }
    }
}

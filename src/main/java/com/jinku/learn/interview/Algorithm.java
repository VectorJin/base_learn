package com.jinku.learn.interview;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试算法合集
 */
public class Algorithm {

    //====================探探算法面试=======================
    /**
     * 探探算法：二分查找
     */
    @org.junit.Test
    public void binarySearch() {
        int[] sorted = new int[]{1, 2, 5, 6, 8, 9};
        System.out.println(helper(5, sorted, 0, sorted.length - 1));
    }

    private int helper(int value, int[] sorted, int left, int right) {
        int mid = (right - left) / 2 + left;
        if (value == sorted[mid]) {
            return mid;
        }
        if (value > sorted[mid]) {
            return helper(value, sorted, mid + 1, right);
        }
        return helper(value, sorted, left, mid - 1);
    }

    /**
     * 探探算法：链表翻转
     */
    @org.junit.Test
    public ListNode reverseList(ListNode head) {
        // leetcode Num206
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //====================BOSS直聘算法面试=======================

    /**
     * 阶乘相加
     *
     * @param n
     * @return
     */
    @org.junit.Test
    public static long sum(int n) {
        long sum = 0;
        long term = 1;
        for (int i = 1; i <= n; i++) {
            term *= i;
            sum += term;
        }
        return sum;
    }

    /**
     * N * N 矩阵 行列交换
     *
     * @param array
     */
    public static void matrixExchange(int[][] array) {
        if (array == null) {
            return;
        }
        int n = array.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = tmp;
            }
        }
    }

    /**
     * 模拟阻塞队列
     *
     * @param <T>
     */
    public static class BlockingQueue<T> {

        private List<T> list;
        private int capacity;
        private ReentrantLock lock;
        private Condition notEmpty;
        private Condition notFull;

        BlockingQueue(int capacity) {
            this.capacity = capacity;
            list = new ArrayList<>();
            lock = new ReentrantLock();
            notEmpty = lock.newCondition();
            notFull = lock.newCondition();
        }

        public void offer(T obj) throws InterruptedException {
            lock.lock();
            try {

                while (list.size() == capacity) {
                    // 队列已满 一直等待 直到被唤醒
                    notFull.await();
                }

                list.add(obj);
                notEmpty.signal();

            } finally {
                lock.unlock();
            }
        }

        public T poll() throws InterruptedException {
            lock.lock();
            try {

                while (list.size() == 0) {
                    // 队列已空 一直等待 直到被唤醒
                    notEmpty.await();
                }
                notFull.signal();
                return list.remove(list.size() - 1);
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 模拟8个运动员，其中3个运动员到达终点，则其他的运动员终止比赛
     */
    public static class Runner implements Runnable {

        private int number;// 编号
        private CountDownLatch downLatch;// 计数器锁

        public Runner(int number, CountDownLatch downLatch) {
            this.number = number;
            this.downLatch = downLatch;
        }

        @Override
        public void run() {
            Random random = new Random(10);
            try {
                // 模拟运动员比赛
                Thread.sleep((random.nextInt() + 1) * 1000);
                downLatch.countDown();
                System.out.println("runner-" + number + " done!");
            } catch (InterruptedException e) {
                // 被外部中断
                System.out.println("runner-" + number + " interrupted!");
            }
        }
    }

    @Test
    public void testRunner() throws InterruptedException {
        CountDownLatch downLatch = new CountDownLatch(3);
        int total = 8;
        List<Thread> threadList = new ArrayList<>();
        for (int i = 1; i <= total; i++) {
            Runner runner = new Runner(i, downLatch);
            Thread thread = new Thread(runner);
            thread.start();
            threadList.add(thread);
        }
        downLatch.await();

        for (Thread thread : threadList) {
            thread.interrupt();
        }
    }

    //====================伴鱼算法面试=======================

    /**
     * 对于一个数组，分行打印 a + b = c + d 的下标
     * [1, 2, 3, 4, 5, 6, 7, 8]
     *
     * @param array : 整数数组
     */
    public void printIndex(int[] array) {
        Map<Integer, List<Node>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                List<Node> nodeList = map.getOrDefault(sum, new ArrayList<>());
                nodeList.add(new Node(i, j));
                map.put(sum, nodeList);
            }
        }
        for (Map.Entry<Integer, List<Node>> entry : map.entrySet()) {
            List<Node> nodeList = entry.getValue();
            for (int i = 0; i < nodeList.size(); i++) {
                Node node1 = nodeList.get(i);
                for (int j = i + 1; j < nodeList.size(); j++) {
                    Node node2 = nodeList.get(j);
                    if (node1.hasMerged(node2)) {
                        continue;
                    }
                    System.out.println(node1.num1 + "-" + node1.num2 + ":" + node2.num1 + "-" + node2.num2);
                }
            }
        }
    }

    private static class Node {
        int num1;
        int num2;

        private Node(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        // 1, 2, 2, 3
        // 0, 1, 2, 3
        // 3 -> node (0 ,1), node(0,2)
        private boolean hasMerged(Node node) {
            return num1 == node.num1 || num2 == node.num2;
        }
    }

}

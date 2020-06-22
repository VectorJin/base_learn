package com.jinku.learn.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
     * 阶乘向加
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
}

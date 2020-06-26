package com.jinku.learn.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * 线程池
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            executor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "-- start");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + "-- end");
                } catch (Exception e) {
                }
            });
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
        executor.shutdown();
    }

    @Test
    public void testSynchronousQueue() {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        System.out.println(queue.offer(1));
    }
}

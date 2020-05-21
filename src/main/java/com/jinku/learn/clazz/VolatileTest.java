package com.jinku.learn.clazz;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileTest {

    private volatile int shared = 1;
    private int a = 0;
    private int b = 0;
    private int c = 0;

    @Test
    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            a = 0;
            b = shared + 1;
            c = 0;
        });
        executorService.execute(() -> {
            a = 2;
            shared = 3;
            c = b + 1;
        });
    }
}

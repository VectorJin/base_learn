package com.jinku.learn.clazz;

public class ThreadLock {

    private volatile int i;

    public void update() {
        i++;
    }

    public static void main(String[] args) {
        ThreadLock threadLock = new ThreadLock();
        threadLock.update();
        System.out.println(threadLock.i);
    }
}

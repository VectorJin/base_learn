package com.jinku.learn.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureExample {

    public static void main(String[] args) {
//        CompletableFuture<Boolean> cf = CompletableFuture.supplyAsync(() -> {
//            System.out.println("run start");
//            try {
//                Thread.sleep( 2 * 1000);
//            } catch (Exception e) {
//
//            }
//            System.out.println("run end");
//            return true;
//        });

        CompletableFuture<Boolean> cf = CompletableFuture.completedFuture(true);
        cf.thenAccept((e) -> {
            System.out.println("run 1" + e);
            System.out.println(Thread.currentThread().getName());
        }).join();
    }
}

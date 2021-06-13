package edu.prahlad.java.course2.executorFramework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class ExecutorDemo {
    public static void main(String[] args) {
//        executorService();
//        callable();
//        future();
    }

    private static void future() {
        //synchronous code
        var executor = Executors.newFixedThreadPool(2);
        try {
            var future = executor.submit(() -> {
                LongTask.simulate();
                return 1;
            });
            System.out.println("Do more work");
            var result = future.get();
            System.out.println("result = " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static void callable() {
        var executor = Executors.newFixedThreadPool(2);
        try {
            var future = executor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                return 1;
            });
        } finally {
            executor.shutdown();
        }
    }

    private static void executorService() {
        var executor = Executors.newFixedThreadPool(2);
        try {
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        } finally {
            executor.shutdown();
        }
    }
}

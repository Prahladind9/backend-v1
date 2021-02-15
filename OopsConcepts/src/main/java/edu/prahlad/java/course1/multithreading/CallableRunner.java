package edu.prahlad.java.course1.multithreading;

import java.util.concurrent.*;

/**
 * Thread returning value
 */

class CallableTask implements Callable<String> {
    private final String name;
    public CallableTask(String name){
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello " + name;
    }
}

public class CallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<String> welcomeFuture =
                executorService.submit(new CallableTask("rao"));
        System.out.println("new CallableTask(\"rao\") executed ");
        String welcomeMessage = welcomeFuture.get();
        System.out.print(welcomeMessage);
        System.out.print("\nMain completed");

        executorService.shutdown();
    }
}

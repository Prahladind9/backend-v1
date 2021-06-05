package edu.prahlad.java.course1.multithreading;

import java.util.concurrent.*;

class CallableTask implements Callable<String> {
    private String name;
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

        Future<String> welcomeFuture = executorService.submit(new CallableTask("rao"));
        System.out.println(" new CallableTask(\"rao\") executed");
        System.out.println(welcomeFuture.get());

        System.out.println("Main Completed");
        executorService.shutdown();
    }
}

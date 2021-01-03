package edu.prahlad.java.multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallableRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<CallableTask> callableTasks =
                List.of(
                new CallableTask("rao"),
                new CallableTask("ranga"),
                new CallableTask("ray")
        );
        List<Future<String>> results =
                executorService.invokeAll(callableTasks);
        for (Future<String> result: results) {
            System.out.println(result.get());
        }

        executorService.shutdown();
    }
}

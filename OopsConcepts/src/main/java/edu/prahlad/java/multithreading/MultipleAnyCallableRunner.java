package edu.prahlad.java.multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleAnyCallableRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<CallableTask> callableTasks =
                List.of(
                new CallableTask("rao"),
                new CallableTask("ranga"),
                new CallableTask("ray")
        );
        String result =
                executorService.invokeAny(callableTasks);
        System.out.println(result);

        executorService.shutdown();
    }
}

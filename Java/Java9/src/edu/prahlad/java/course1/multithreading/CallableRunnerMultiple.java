package edu.prahlad.java.course1.multithreading;

import java.util.List;
import java.util.concurrent.*;

public class CallableRunnerMultiple {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<CallableTask> callableTaskList = List.of(new CallableTask("rao"), new CallableTask("sai"), new CallableTask("gsp"));
        List<Future<String>> results = executorService.invokeAll(callableTaskList);
        for (Future<String> result: results){
            System.out.println(result.get());
        }
        executorService.shutdown();
    }
}

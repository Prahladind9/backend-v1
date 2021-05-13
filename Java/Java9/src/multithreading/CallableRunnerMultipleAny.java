package multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableRunnerMultipleAny {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<CallableTask> callableTaskList = List.of(new CallableTask("rao"), new CallableTask("sai"), new CallableTask("gsp"));
        String result = executorService.invokeAny(callableTaskList);
        System.out.println(result);

        executorService.shutdown();
    }
}

package edu.prahlad.java.course2.executorFramework;

import java.time.Duration;
import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CompletableFuturesDemo {
    public static void main(String[] args) {
//        completableFuture();
//        synchronousAPI();
//        asynchronousAPI();
//        completable();
//        handleException();
//        transformResult();
//        composingCompletableFuture();
//        combingCompletableFuture();
//        waitingForManyTasks();
//        waitingForFirstTask();
//        handlingTimeouts();
//        getQuoteProject();
//        getManyQuoteProject();
        getManyQuoteProjectWithExecutionTime();
    }

    private static void getManyQuoteProjectWithExecutionTime() {
        var start = LocalDate.now();
        var service = new FlightService();
        var futures = service.getQuotes()
                .map(future -> future.thenAccept(System.out::println))
                .collect(Collectors.toList());

        CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    var end = LocalDate.now();
                    var duration = Duration.between(start, end);
                    System.out.println("Retrieved all quotes in " + duration.toMillis()+ " msec.");
                });
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void getManyQuoteProject() {
        var service = new FlightService();
        var futures = service.getQuotes()
                .map(future -> future.thenAccept(System.out::println))
                .collect(Collectors.toList());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void getQuoteProject() {
        var service = new FlightService();
        service.getQuote("site1")
                .thenAccept(System.out::println);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void handlingTimeouts() {
        var future = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 1;
        });

        try {
            var result = future
                    .completeOnTimeout(1, 1, TimeUnit.SECONDS)
                    .get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void waitingForFirstTask() {
        var first = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 20;
        });

        var second = CompletableFuture.supplyAsync(() -> 20);

        var fastest = CompletableFuture.anyOf(first, second)
                .thenAccept(temp -> System.out.println(temp));
    }

    private static void waitingForManyTasks() {
        var first = CompletableFuture.supplyAsync(() -> 1);
        var second = CompletableFuture.supplyAsync(() -> 2);
        var third = CompletableFuture.supplyAsync(() -> 3);

        var all = CompletableFuture.allOf(first, second, third);
        all.thenRun(() -> {
            try {
                System.out.println(first.get());
                System.out.println(second.get());
                System.out.println(third.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("All tasks completed successfully");
        });
    }

    private static void combingCompletableFuture() {
        var first =
                CompletableFuture
                        .supplyAsync(() -> "20USD")
                        .thenApply(str -> {
                            var price = str.replace("USD", "");
                            return Integer.parseInt(price);
                        });

        var second =
                CompletableFuture.supplyAsync(() -> 0.9);

        first.thenCombine(second, (price, exchangeRate) -> price * exchangeRate)
                .thenAccept(result -> System.out.println(result));
    }

    private static void composingCompletableFuture() {
        //id -> email
        //email -> playlist

        getUserEmailAsync()
                .thenCompose(CompletableFuturesDemo::getPlaylistAsync)
                .thenAccept(playlist -> System.out.println(playlist));

    }

    private static CompletableFuture<String> getUserEmailAsync() {
        return CompletableFuture.supplyAsync(() -> "email");
    }

    private static CompletableFuture<String> getPlaylistAsync(String email) {
        return CompletableFuture.supplyAsync(() -> "playlist");
    }

    private static void transformResult() {
        var future = CompletableFuture.supplyAsync(() -> 20);
        var result = future
                .thenApply(CompletableFuturesDemo::toFahrenheit)
                .thenAccept(f -> System.out.println(f + "F"));

    }

    private static int toFahrenheit(int celsius) {
        return (int) (celsius * 1.8) + 32;
    }

    private static void handleException() {
        var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting the current weather");
            throw new IllegalStateException();
        });

        try {
            var temperature = future.exceptionally(ex -> 1).get();
            System.out.println(temperature);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void completable() {
        var future = CompletableFuture.supplyAsync(() -> 1);
        future.thenRun(() -> System.out.println("Sync Done"));
        future.thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Async Done");
        });

        future.thenAccept(result -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });

        future.thenAcceptAsync(result -> {
            System.out.println("Async " + Thread.currentThread().getName());
            System.out.println("Async " + result);
        });


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void asynchronousAPI() {
        var service = new MailService();
        service.sendAsync();
        System.out.println("Hello World");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void synchronousAPI() {
        //synchronous or blocking or sequential
        var service = new MailService();
        service.send();
        System.out.println("Hello World");
    }

    private static void completableFuture() {
//        Runtime.getRuntime().availableProcessors();
//        ForkJoinPool.commonPool();
        try {
            Runnable task = () -> System.out.println("a");
            var future = CompletableFuture.runAsync(task);
            System.out.println(future.get());


            Supplier<Integer> taskS = () -> 1;
            var futureS = CompletableFuture.supplyAsync(taskS);
            System.out.println(futureS.get());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

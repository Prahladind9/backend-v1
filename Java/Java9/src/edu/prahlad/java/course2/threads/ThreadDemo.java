package edu.prahlad.java.course2.threads;

import edu.prahlad.java.course2.threads.downloadFileTask.*;
import edu.prahlad.java.course2.threads.downloadStatus.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadDemo {
    public static void main(String[] args) {
        //basics();
//        thread();
//        joiningThread();
//        interruptThread();

        //concurrencyIssue
//        raceCondition();

        //concurrencySolution
//        confinement();
//        locks();
//        synchronizedSoln();
//        synchronizedSolnBest();
//        volatileKeyword();
//        threadSignalling();
//        atomic();
//        adders();
//        synchronizedCollection();
        concurrentCollections();
    }

    private static void concurrentCollections() {
        Map<Integer, String> normalMap = new HashMap<>();
        normalMap.put(1, "a");
        normalMap.get(1);
        normalMap.remove(1);

        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "a");
        map.get(1);
        map.remove(1);
    }

    private static void synchronizedCollection() {
        Collection<Integer> collection =
                Collections.synchronizedCollection(new ArrayList<>());
        var thread1 = new Thread(() -> {
            collection.addAll(Arrays.asList(1, 2, 3));
        });
        var thread2 = new Thread(() -> {
            collection.addAll(Arrays.asList(4, 5, 6));
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(collection);

    }

    private static void adders() {
        var status = new DownloadStatusAdders();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTaskStatus(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(status.getTotalBytes());
    }

    private static void atomic() {
        var status = new DownloadStatusAtomic();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTaskStatus(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(status.getTotalBytes());
    }

    private static void threadSignalling() {
        var status = new DownloadStatusVolatile();
        var thread1 = new Thread(new DownloadFileTaskStatusNotify(status));
        var thread2 = new Thread(() -> {
            while (!status.isDone()) {
                synchronized (status) {
                    try {
                        status.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();
    }

    private static void volatileKeyword() {
        var status = new DownloadStatusVolatile();
        var thread1 = new Thread(new DownloadFileTaskStatusVolatile(status));
        var thread2 = new Thread(() -> {
            while (!status.isDone()) {
            }
            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();
    }

    private static void synchronizedSolnBest() {
        var status = new DownloadStatusSynchronisedBest();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTaskStatus(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(status.getTotalBytes());
    }

    private static void synchronizedSoln() {
        var status = new DownloadStatusSynchronised();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTaskStatus(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(status.getTotalBytes());
    }

    private static void locks() {
        var status = new DownloadStatusLock();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTaskStatus(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(status.getTotalBytes());
    }

    private static void confinement() {

        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTaskStatusConfinement> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            var task = new DownloadFileTaskStatusConfinement();
            tasks.add(task);

            var thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        var totalBytes = tasks.stream()
                .map(t -> t.getStatus().getTotalBytes())
                .reduce(Integer::sum);

        System.out.println(totalBytes);
    }

    private static void raceCondition() {
        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTaskStatus(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(status.getTotalBytes());
    }

    private static void interruptThread() {
        Thread thread = new Thread(new DownloadFileTaskInterrupt());
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }

    private static void joiningThread() {
        Thread thread = new Thread(new DownloadFileTask());
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("File is ready to be scanned.");
    }

    private static void thread() {
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
        }
    }

    private static void basics() {
        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}

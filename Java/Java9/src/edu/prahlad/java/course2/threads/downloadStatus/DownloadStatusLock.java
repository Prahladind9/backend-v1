package edu.prahlad.java.course2.threads.downloadStatus;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatusLock extends DownloadStatus {
    private int totalBytes;
    private Lock lock = new ReentrantLock();

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes() {
        lock.lock();
        try {
            totalBytes++;
        } finally {
            lock.unlock();
        }

        //non-atomic operation
        /**
         * 3 Steps under the hood
         * 1) Read value from the main-memory & store in the CPU
         * 2) CPU is going to increment the value
         * 3) CPU updates the value in the memory
         */
    }
}

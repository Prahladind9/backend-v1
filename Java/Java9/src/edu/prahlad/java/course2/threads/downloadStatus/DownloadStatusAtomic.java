package edu.prahlad.java.course2.threads.downloadStatus;

import java.util.concurrent.atomic.AtomicInteger;

public class DownloadStatusAtomic extends DownloadStatus {
    private boolean isDone;
    private AtomicInteger totalBytes = new AtomicInteger();
    private int totalFiles;

    public int getTotalBytes() {
        return totalBytes.get();
    }

    public void incrementTotalBytes() {
        totalBytes.incrementAndGet(); //++a
//        totalBytes.getAndIncrement(); //a++
    }

    public int getTotalFiles() {
        return totalFiles;
    }

    public boolean isDone() {
        return isDone;
    }

    public void done() {
        isDone = true;
    }
}

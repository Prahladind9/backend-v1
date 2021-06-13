package edu.prahlad.java.course2.threads.downloadFileTask;

import edu.prahlad.java.course2.threads.downloadStatus.DownloadStatus;
import edu.prahlad.java.course2.threads.downloadStatus.DownloadStatusVolatile;

public class DownloadFileTaskStatusNotify implements Runnable{

    private DownloadStatusVolatile status;
    public DownloadFileTaskStatusNotify(DownloadStatus status) {
        this.status = (DownloadStatusVolatile) status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());

        for (int i = 0; i < 1_000_000; i++) {
            if(Thread.currentThread().isInterrupted()) return;
            status.incrementTotalBytes();
        }

        status.done();
        synchronized (status){
            status.notifyAll();
        }

        System.out.println("Download complete: "+ Thread.currentThread().getName());
    }
}

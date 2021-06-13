package edu.prahlad.java.course2.threads.downloadFileTask;

import edu.prahlad.java.course2.threads.downloadStatus.DownloadStatus;

public class DownloadFileTaskStatusConfinement implements Runnable{

    private DownloadStatus status;
    public DownloadFileTaskStatusConfinement() {
        this.status = new DownloadStatus();
    }

    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());

        for (int i = 0; i < 10_000; i++) {
            if(Thread.currentThread().isInterrupted()) return;
            status.incrementTotalBytes();
        }

        System.out.println("Download complete: "+ Thread.currentThread().getName());
    }


    public DownloadStatus getStatus() {
        return status;
    }
}

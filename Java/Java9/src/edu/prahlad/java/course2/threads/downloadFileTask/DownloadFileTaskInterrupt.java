package edu.prahlad.java.course2.threads.downloadFileTask;

public class DownloadFileTaskInterrupt implements Runnable{

    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if(Thread.currentThread().isInterrupted()) return;
            System.out.println("Downloading byte " + i);
        }

        System.out.println("Download complete: "+ Thread.currentThread().getName());
    }
}
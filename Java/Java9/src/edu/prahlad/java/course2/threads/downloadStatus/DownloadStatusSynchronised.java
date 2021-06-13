package edu.prahlad.java.course2.threads.downloadStatus;

public class DownloadStatusSynchronised extends DownloadStatus {
    private int totalBytes;
    private int totalFiles;

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes() {
        //same monitor object is not preferred - this, in our case
        synchronized (this) { //monitor object
            totalBytes++;
        }

    }

    public void incrementTotalFiles() {
        synchronized (this) {
            totalFiles++;
        }
    }

    /*
    //same as
    public synchronized void incrementTotalFiles(){
            totalFiles++;
    }
     */

    public int getTotalFiles() {
        return totalFiles;
    }
}

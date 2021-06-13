package edu.prahlad.java.course2.threads.downloadStatus;

public class DownloadStatusSynchronisedBest extends DownloadStatus {
    private int totalBytes;
    private int totalFiles;
    private Object totalBytesLock = new Object();
    private Object totalFilesLock = new Object();

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes() {
        synchronized (totalBytesLock){
            totalBytes++;
        }

    }

    public void incrementTotalFiles(){
        synchronized (totalFilesLock) {
            totalFiles++;
        }
    }

    public int getTotalFiles() {
        return totalFiles;
    }
}

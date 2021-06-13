package edu.prahlad.java.course2.threads.downloadStatus;

public class DownloadStatus {
    private int totalBytes;

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes(){
        totalBytes++; //non-atomic operation
        /**
         * 3 Steps under the hood
         * 1) Read value from the main-memory & store in the CPU
         * 2) CPU is going to increment the value
         * 3) CPU updates the value in the memory
         */
    }
}

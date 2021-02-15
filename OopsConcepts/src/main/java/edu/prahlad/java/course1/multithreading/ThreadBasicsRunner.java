package edu.prahlad.java.course1.multithreading;

/**
 * 2 ways to create the thread
 *
 * extends Thread
 * implements Runnable
 *
 * Life Cycle
 * NEW
 * RUNNABLE
 * RUNNING
 * BLOCKED/WAITING
 * TERMINATED/DEAD
 *
 * Priority is request, which may not be honered
 */

class Task1 extends Thread {
    public void run(){ //SIGNATURE
        System.out.println("\nTask1 Started");
        for(int i = 101; i <= 199; i++){
            System.out.print(i + " ");
        }
        System.out.println("\nTask1 Done");
    }
}

class Task2 implements Runnable{

    @Override
    public void run() {
        System.out.println("\nTask2 Started");
        for(int i = 201; i <= 299; i++){
            System.out.print(i + " ");
        }
        System.out.println("\nTask2 Done");
    }
}

public class ThreadBasicsRunner {
    public static void main(String[] args) throws InterruptedException {
        System.out.print("\nMain Start");

        System.out.print("\nTask1 Kicked off ");
        //Task1
        Task1 task1 = new Task1();
        task1.setPriority(Thread.MAX_PRIORITY);
        task1.start();
        //start is to run in thread parallel
        //run() is a typical method impl - no threads are involved on this method call

        System.out.print("\nTask2 Kicked off ");
        //Task2
        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        task2Thread.start();


        //Wait for task1 & task2 to complete
        task1.join();
        task2Thread.join();

        System.out.print("\nTask3 Kicked off ");
        //Task3
        for(int i = 301; i <= 399; i++){
            System.out.print(i + " ");
        }
        System.out.print("\nTask3 Done");

        System.out.print("\nMain Done");
    }

    private static void basicTasks() {
        System.out.println("\nMain Start");
        //Task1
        for(int i = 101; i <= 199; i++){
            System.out.print(i + " ");
        }
        System.out.println("\nTask1 Done");

        //Task2
        for(int i = 201; i <= 299; i++){
            System.out.print(i + " ");
        }
        System.out.println("\nTask2 Done");

        //Task3
        for(int i = 301; i <= 399; i++){
            System.out.print(i + " ");
        }
        System.out.println("\nTask3 Done");

        System.out.println("\nMain Done");
    }

}

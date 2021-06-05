package course1.multithreading;

class Task1 extends Thread{
    public void run(){
        System.out.println("\nTask1 Started");
        for (int i = 101; i < 199; i++) {
            System.out.print(i + " ");
        }
//        Thread.yield();
        System.out.println("\nTask1 Done");
    }
}

class Task2 implements Runnable{

    @Override
    public void run() {
        System.out.println("\nTask2 Started");
        for (int i = 201; i < 299; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nTask2 Done");
    }
}
public class ThreadBasicsRunner2 {

    public static void main(String[] args) throws InterruptedException {

        //Task1
        System.out.println("\nTask1 Kicked Off");
        Task1 task1 = new Task1();
        task1.start();      //task1.run();//Sequential run

        System.out.println("\nTask2 Kicked Off");
        //Task2
        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        task2Thread.start();


        //wait for task1 to complete
        task1.join();
        task2Thread.join();

        System.out.println("\nTask3 Kicked Off");
        //Task3
        for (int i = 301; i < 399; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nTask3 Done");

        System.out.println("\nMain Method Done");
    }
}

package multithreading;

public class ThreadBasicsRunner {

    public static void main(String[] args) {
        //Task1
        for (int i = 101; i < 199; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nTask1 Done");
        //Task2
        for (int i = 201; i < 299; i++) {
            System.out.print(i + " ");
        }
        System.out.print("\nTask2 Done\n");
        //Task3
        for (int i = 301; i < 399; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nTask3 Done");

        System.out.println("\nMain Method Done");
    }
}

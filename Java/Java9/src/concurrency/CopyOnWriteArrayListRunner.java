package concurrency;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListRunner {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>(); //Only syncs add operation thread

        //Thread - 3 inserting
        list.add("Ant");
        list.add("Bat");
        list.add("Cat");

        //Threads - 1000 consuming
        for (String element: list){
            System.out.println(element);
        }
    }
}

package edu.prahlad.java.concurrency;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListRunner {

    //add - copy and new array is created
    //get - no impact

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();

        //Threads - 3
        list.add("Car");
        list.add("Bike");
        list.add("Cat");

        //Threads - 1000
        for(String element: list){
            System.out.println(element);
        }
    }
}

package edu.prahlad.java.course2.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZRunner {
    public static void main(String[] args) {
//        iterablesExample();
//        CollectionsDemo.showCollection();
//        CollectionsDemo.showList();

        comparableExample();

    }

    private static void comparableExample() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("b", "e3"));
        customers.add(new Customer("a", "e2"));
        customers.add(new Customer("c", "e1"));
        Collections.sort(customers);
        System.out.println(customers);

        Collections.sort(customers, new EmailComparator());
        System.out.println(customers);
    }

    private static void iterablesExample() {
        var list = new GenericList<String>();
        list.add("a");
        list.add("b");
        var iterator = list.iterator();
        while(iterator.hasNext()){
            var current =  iterator.next();
            System.out.println(current);
        }

        for (var item: list)
            System.out.println(item);
    }
}

package leetcode.learn.DataStructures.Collection;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListDemo {
    public static void main(String[] args) {
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Diana");
        staff.addLast("Harry");
        staff.addLast("Romeo");
        staff.addLast("Tom");

        // | in the comments indicates the iterator position
        ListIterator<String> iterator = staff.listIterator(); // |DHRT
        iterator.next(); // D|HRT
        iterator.next(); // DH|RT

        //Add more elements after second element

        iterator.add("Juliet"); //DHJ|RT
        iterator.add("Nina");  //DHJN|RT

        iterator.next(); //DHJNR|T

        //Remove teh last transversed element
        iterator.remove(); //DHJN|T

        //Print all elements
        System.out.println(iterator.nextIndex());
        iterator.next();
        System.out.println(iterator.hasNext());
        System.out.println(iterator.hashCode());

        System.out.println(staff);
        System.out.println("Expected: [DHJNT]");
    }
}

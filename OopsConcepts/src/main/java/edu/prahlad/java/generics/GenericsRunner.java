package edu.prahlad.java.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsRunner {

    static <X> X returnSameValueGeneric(X value){
        return value;
    }

    static <X extends List> void duplicate(X list){
        list.addAll(list);
    }

    public static void main(String[] args) {
        versionOne();

        //*******************//

        System.out.println(returnSameValueGeneric(new String("Custom Generic Method")));
        System.out.println(returnSameValueGeneric(Integer.valueOf(6)));

        ArrayList<String> listK = returnSameValueGeneric(
                new ArrayList<String>(List.of("Cat", "Horse", "HP"))
        );
        System.out.println(listK);

        duplicate(listK);
        System.out.println(listK);


        //*******************//

        MyCustomList2<Long> list = new MyCustomList2<>();
        list.addElement(8l);
        list.addElement(2l);
        Long value = list.get(0);

        System.out.println(list);

        MyCustomList2<Integer> list2 = new MyCustomList2<>();
        list2.addElement(Integer.valueOf(5));
        list2.addElement(Integer.valueOf(7));
        Integer number = list2.get(0);

        System.out.println(list2);
    }

    private static void versionOne() {
        MyCustomList<String> list = new MyCustomList<>();
        list.addElement("Element 1");
        list.addElement("Element 2");
        String value = list.get(0);

        System.out.println(list);

        MyCustomList<Integer> list2 = new MyCustomList<>();
        list2.addElement(Integer.valueOf(5));
        list2.addElement(Integer.valueOf(7));
        Integer number = list2.get(0);

        System.out.println(list2);
    }
}

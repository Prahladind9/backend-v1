package edu.prahlad.java.course1.generics;

import java.util.ArrayList;
import java.util.List;

//Generic with Type
public class GenericRunner {

    //Generic Type
    static <X> X doubleValue(X value){
        return value;
    }

    //generic restricted to class that extend List
    //Advantage is all the List - methods are accessible on the variable
    static <X extends List> void duplicate(X list){
        list.addAll(list);
    }

    //wildCards - upperBounded
    //Any List of type extending Number is valid list > common logic
    static double sumOfNumberList(List<? extends  Number> numbers){
        double sum = 0.0;
        for (Number number: numbers){
            sum += number.doubleValue();
        }

        return sum;
    }

    //wildCards - lowerBounded
    //SubTypes are all accepted
    static void addACoupleOfValues(List<? super Number> numbers){
       numbers.add(1);
        numbers.add(1.0);
        numbers.add(1.0f);
        numbers.add(1l);

    }

    public static void main(String[] args) {
        List emptyList = new ArrayList<Number>();
        addACoupleOfValues(emptyList);
        System.out.println(emptyList);

        Integer integer = doubleValue(Integer.valueOf(2));
        String string = doubleValue(new String());

        ArrayList<Integer> numbers = new ArrayList<>(List.of(1,2,3));
        System.out.println(numbers);
        duplicate(numbers);
        System.out.println(numbers);

        MyCustomList<String> listString = new MyCustomList<>();
        listString.addElement("Element 1");
        listString.addElement("Element 2");

        System.out.println(listString);

        MyCustomList<Integer> listInteger = new MyCustomList<>();
        listInteger.addElement(0);
        listInteger.addElement(1);
        Integer val = listInteger.get(1);
        System.out.println(val);
        System.out.println(listInteger);


        MyCustomNumberList<Long> listLong = new MyCustomNumberList<>();
        listLong.addElement(0l);
        listLong.addElement(1l);
        System.out.println(listLong);
    }
}

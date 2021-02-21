package edu.prahlad.java.course2.oop.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    void nonGenericList(){
        List list = new ArrayList();
        list.add("foo");
        Object o = list.get(0);
        String foo = (String) o;
    }

    public static <T> T returnType(T argument){
        return argument;
    }

}

interface consumerNoGenerics {
    void consume(String parameter);
}
interface Consumer<T> {
    void consume(T parameter);
}

class IntegerConsumer implements Consumer<Integer>{

    @Override
    public void consume(Integer parameter) {
        System.out.println("Parameter: "+ parameter);
    }
}

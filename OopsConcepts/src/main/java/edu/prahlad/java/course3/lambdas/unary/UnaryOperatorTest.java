package edu.prahlad.java.course3.lambdas.unary;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorTest {


    public static void main(String args[]) {
        PersonU person = new PersonU();
        UnaryOperator<PersonU> operator = (p) -> {
            p.name = "John";
            p.age = 34;
            return p;
        };

        operator.apply(person);
        System.out.println("Person Name: " + person.getName() + " Person Age: " + person.getAge());

        IntUnaryOperator operator2 = num -> num * num;
        System.out.println(operator2.applyAsInt(25));

    }


}

class PersonU {
    String name;
    int age;

    PersonU() {
    }

    PersonU(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}


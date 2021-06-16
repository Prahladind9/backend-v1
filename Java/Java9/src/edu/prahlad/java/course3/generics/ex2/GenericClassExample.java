package edu.prahlad.java.course3.generics.ex2;

public class GenericClassExample {
    public static void main(String[] args) {
        Person<Employee> e1 = new Person<>();
        Person<Contact> c1 = new Person<>();

        Employee e = new Employee("John", "Slattery", "1234");
        Contact c = new Contact("Mr", "Rao", "GSP", "121212121");

        e1.setPerson(e);
        c1.setPerson(c);

        System.out.println(e1.getPerson().toString());
        System.out.println(c1.getPerson().toString());
    }
}

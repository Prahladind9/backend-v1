package edu.prahlad.java.course3.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo {

    Map<Integer, Employee> empMap = new HashMap<>();

    public void populateEmployee() {
        empMap.put(123, new Employee("Alex", 23, 12000));
    }

    public Optional<Employee> getEmployee(Integer employeeId) {
        // Before returning the employee object we are wrapping it into an Optional
        return Optional.ofNullable(empMap.get(employeeId));
    }

    public static String getDefaultValue(){
        return "default";
    }

    public static void main(String[] args) {

        OptionalDemo demo = new OptionalDemo();
        demo.populateEmployee();
        Optional<Employee> emp = demo.getEmployee(123);
        emp.ifPresent(System.out::println);

        Optional<String> optional = Optional.ofNullable(null);
        // This will throw exception because optional contains a null value.
       // System.out.println(optional.get());

        // This will return the default value.
        System.out.println(optional.orElse("default string"));

        // This will return the default value.
        System.out.println(optional.orElseGet(OptionalDemo::getDefaultValue));

        // This will throw exception
        /*try {
            System.out.println(optional.orElseThrow(() -> new Exception("Resource not found.")));
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        Optional<String> optional2 = Optional.ofNullable("orange");
        // Since the filter condition is matched, this will return the optional.
        System.out.println(optional2.filter(str -> str.equals("orange")));

        // Since the filter condition is not matched, this will return empty optional.
        System.out.println(optional2.filter(str -> str.equals("apple")));

        // Creating an Optional of Employee object.
        Optional<Employee> optional3 = Optional.of(new Employee("Adam", 54, 20000));


        // Creating an Optional of Employee object.
        Optional<Employee> optional4 = Optional.of(new Employee("Adam", 54, 20000));
        optional4.flatMap(emp2 -> emp2.getSalary())
                .filter(sal -> sal > 10000)
                .ifPresent(System.out::println);
    }
}

class Employee {
    String name;
    int age;
    int salary;
    String country;

    Employee(String name) {
        this.name = name;
    }

    Employee(String name, int age, int salary, String country) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.country = country;
    }

    Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Optional<Integer> getSalary() {
        return Optional.of(salary);
    }

    public Integer getSalaryPlain() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
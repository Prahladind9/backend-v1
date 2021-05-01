package edu.prahlad.java.course3.stream;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {
    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("done");
        list.add("far");
        list.add("away");
        list.add("again");

        Map<String,Integer> nameMap = list.stream()
                .collect(Collectors.toMap(s -> s , s -> s.length()));

        System.out.println(nameMap);

        Map<String,Integer> nameHashMap = list.stream()
                .collect(Collectors.toMap(s -> s , s -> s.length(), (s1,s2) -> s1, HashMap::new));

        System.out.println(nameHashMap);

        List<String> unmodifiableList = list.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        System.out.println(unmodifiableList);


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 23, 23000));
        employeeList.add(new Employee("Alex", 23, 3000));
        employeeList.add(new Employee("Ben", 63, 25000));
        employeeList.add(new Employee("Dave", 34, 56000));
        employeeList.add(new Employee("Jodi", 43, 67000));
        employeeList.add(new Employee("Ryan", 53, 54000));

        LinkedList<String> empName = employeeList.stream()
                .map(emp -> emp.getName())
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println(empName);

        Set<String> empNameSet = employeeList.stream()
                .map(emp -> emp.getName())
                .collect(Collectors.toSet());

        System.out.println(empNameSet);


        long count = employeeList.stream()
                .filter(emp -> emp.getAge() > 30)
                .collect(Collectors.counting()); // Using the counting() method to get count of employees.

        System.out.println(count);

        int summingInt = employeeList.stream()
                .collect(Collectors.summingInt(emp -> emp.getSalary().get()));

        System.out.println(summingInt);

        double average = employeeList.stream()
                .collect(Collectors.averagingInt(emp -> emp.getSalary().get()));

        System.out.println(average);

        //Using minBy() method to get the employee with min salary.
        Optional<Employee> minEmployee = employeeList.stream()
                .collect(Collectors.minBy(Comparator.comparing(t -> t.getSalary().get())));

        System.out.println(minEmployee.get().getName());


        //Using minBy() method to get the employee with min salary.
        Optional<Employee> employee = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalaryPlain)));

        System.out.println(employee.get().getName());


        IntSummaryStatistics summarizingInt = Stream.of("1", "2", "3")
                .collect(Collectors.summarizingInt(Integer::parseInt));
        System.out.println(summarizingInt);



        // Joining all the strings.
        String joinedString = Stream.of("hello", "how", "are" , "you")
                .collect(Collectors.joining());
        System.out.println(joinedString);

        // Joining all the strings with space in between.
        joinedString = Stream.of("hello", "how", "are" , "you")
                .collect(Collectors.joining(" "));
        System.out.println(joinedString);

        // Joining all the strings with space in between and a prefix and suffix.
        joinedString = Stream.of("hello", "how", "are" , "you")
                .collect(Collectors.joining(" " , "prefix","suffix"));
        System.out.println(joinedString);



        // The employees are grouped by country using the groupingBy() method.
        Map<String,List<Employee>> employeeMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName));

        System.out.println(employeeMap);

        Map<String, Set<Employee>> employeeMapSet = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.toSet()));

        System.out.println(employeeMapSet);


        // The employees are grouped by country and age by using the groupingBy() method twice.
        Map<String, Map<Integer,List<Employee>>> employeeMapGroupBy = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.groupingBy(Employee::getAge)));

        System.out.println(employeeMapGroupBy);


        Map<String, Integer> employeeMapSal = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.summingInt(Employee::getSalaryPlain)));

        System.out.println(employeeMapSal);


        Map<String, Optional<Employee>> employeeMapS = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.maxBy(Comparator.comparingInt(Employee::getSalaryPlain))));

        System.out.println(employeeMapS);

        ConcurrentMap<String,List<Employee>> employeeMapC = employeeList.parallelStream()
                .collect(Collectors.groupingByConcurrent(Employee::getName));

        System.out.println(employeeMapC);

        // Partitioning the list based on age.
        Map<Boolean, List<Employee>> employeeMapP = employeeList.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getAge() > 30));

        System.out.println(employeeMapP);



        Map<String, Set<Employee>> employeeMapHM = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName, HashMap::new, Collectors.toSet()));

        System.out.println(employeeMapHM);
    }
}

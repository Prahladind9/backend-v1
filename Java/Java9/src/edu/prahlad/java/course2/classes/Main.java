package edu.prahlad.java.course2.classes;

public class Main {
    public static void main(String[] args) {
        var textBox1 = new TextBox();
        textBox1.setText("Box 1");
        System.out.println(textBox1.text);

        var textBox2 = new TextBox();
        textBox2.setText("Box 2");
        System.out.println(textBox2.text);

        /* before Constructor
        var employee = new Employee();
        //employee.setBaseSalary(-50_000);
        employee.setBaseSalary(50_000);
        employee.setHourlyRate(20);*/

        var employee = new Employee(50_000, 20);
//        System.out.println("numberOfEmployees: " + Employee.numberOfEmployees);
        Employee.printNumberOfEmployees();
        System.out.println("wage: " + employee.calculateWage(10));

        var browser = new Browser();
        browser.navigate("");
    }

}

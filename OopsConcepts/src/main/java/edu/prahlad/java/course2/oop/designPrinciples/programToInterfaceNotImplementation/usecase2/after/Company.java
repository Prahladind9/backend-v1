package edu.prahlad.java.course2.oop.designPrinciples.programToInterfaceNotImplementation.usecase2.after;

/**
 * After: the primary method of the Company class is independent from
 * concrete employee classes.
 * Employee objects are created in concrete company subclasses.
 */
public abstract class Company {
    public abstract Employee[] getEmployees();

    public void createSoftware(){
        Employee[] employees = getEmployees();

        for(Employee employee: employees){
            employee.doWork();
        }
    }
}

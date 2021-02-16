package edu.prahlad.java.course2.oop.designPrinciples.programToInterfaceNotImplementation.usecase2.better;

/**
 * Better: polymorphism helped us simplify the code, but the rest of the
 * Company class still depends on the concrete employee classes
 */
public class Company {
    public void createSoftware(){
        Employee[] employees = new Employee[]{
                new Designer(),
                new Programmer(),
                new Tester()
        };

        for(Employee employee: employees){
            employee.doWork();
        }
    }
    /**
     * The company class remains couple to the employee classes.
     * This is bad because if we introduce new types of companies that work
     * with other types of employees,
     * we'll need to override most of the company class instead if reusing that code.
     */
}

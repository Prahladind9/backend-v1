package commons.bls;

import commons.ds.Employee;
import commons.ds.EmployeeSalary;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class EmployeeSalaryCalculator {
    public List<EmployeeSalary> calculateSalaries(List<Employee> employees){
        System.out.println("Calculating Salaries");
        return Collections.emptyList();
    }
}

package com.spring.professional.report;

import com.spring.professional.ds.EmployeeSalary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class XlsSalaryReport implements SalaryReport {
    public void writeReport(List<EmployeeSalary> employeeSalaries) {
        System.out.println("Writing Xls Report");
    }
}

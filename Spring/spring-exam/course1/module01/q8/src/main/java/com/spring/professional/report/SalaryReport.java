package com.spring.professional.report;

import com.spring.professional.ds.EmployeeSalary;

import java.util.List;

public interface SalaryReport {
    void writeReport(List<EmployeeSalary> employeeSalaries);
}

package com.spring.professional.service;

import com.spring.professional.bls.EmployeeSalaryCalculator;
import com.spring.professional.dao.EmployeeDao;
import com.spring.professional.ds.Employee;
import com.spring.professional.ds.EmployeeSalary;
import com.spring.professional.report.SalaryReport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesSalariesReportService {
    private final EmployeeDao employeeDao;
    private final EmployeeSalaryCalculator employeeSalaryCalculator;
    private final SalaryReport salaryReport;

    EmployeesSalariesReportService(EmployeeDao employeeDao, EmployeeSalaryCalculator employeeSalaryCalculator, SalaryReport salaryReport) {
        this.employeeDao = employeeDao;
        this.employeeSalaryCalculator = employeeSalaryCalculator;
        this.salaryReport = salaryReport;
    }

    public void generateReport() {
        List<Employee> employees = employeeDao.findAll();
        List<EmployeeSalary> employeeSalaries = employeeSalaryCalculator.calculateSalaries(employees);

        salaryReport.writeReport(employeeSalaries);
    }
}

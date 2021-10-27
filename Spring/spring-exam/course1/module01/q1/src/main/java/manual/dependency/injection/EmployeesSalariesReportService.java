package manual.dependency.injection;

import commons.bls.EmployeeSalaryCalculator;
import commons.dao.EmployeeDao;
import commons.ds.Employee;
import commons.ds.EmployeeSalary;
import commons.report.SalaryReport;

import java.util.List;

class EmployeesSalariesReportService {
    private EmployeeDao employeeDao;
    private EmployeeSalaryCalculator calculator;
    private SalaryReport salaryReport;

    EmployeesSalariesReportService(EmployeeDao employeeDao, EmployeeSalaryCalculator calculator, SalaryReport salaryReport) {
        this.employeeDao = employeeDao;
        this.calculator = calculator;
        this.salaryReport = salaryReport;
    }

    void generateReport(){
        List<Employee> employees = employeeDao.findAll();
        List<EmployeeSalary> salaries = calculator.calculateSalaries(employees);
        salaryReport.writeReport(salaries);
    }
}

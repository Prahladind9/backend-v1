package no.dependency.injection;

import commons.bls.EmployeeSalaryCalculator;
import commons.dao.EmployeeDao;
import commons.ds.Employee;
import commons.ds.EmployeeSalary;
import commons.report.PdfSalaryReport;

import java.util.List;

class EmployeesSalariesReportService {
    void generateReport(){
        EmployeeDao dao = new EmployeeDao();
        List<Employee> employees = dao.findAll();

        EmployeeSalaryCalculator calculator = new EmployeeSalaryCalculator();
        List<EmployeeSalary> salaries = calculator.calculateSalaries(employees);

        PdfSalaryReport pdfSalaryReport = new PdfSalaryReport();
        pdfSalaryReport.writeReport(salaries);
    }
}

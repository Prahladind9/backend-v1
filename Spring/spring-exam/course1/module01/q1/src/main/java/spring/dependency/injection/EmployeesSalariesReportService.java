package spring.dependency.injection;

import commons.bls.EmployeeSalaryCalculator;
import commons.dao.EmployeeDao;
import commons.report.SalaryReport;
import org.springframework.stereotype.Service;

@Service
class EmployeesSalariesReportService {
    private final EmployeeDao dao;
    private final EmployeeSalaryCalculator calculator;
    private final SalaryReport salaryReport;

    EmployeesSalariesReportService(EmployeeDao dao, EmployeeSalaryCalculator calculator, SalaryReport salaryReport) {
        this.dao = dao;
        this.calculator = calculator;
        this.salaryReport = salaryReport;
    }

    void generateReport(){
        salaryReport.writeReport(
                calculator.calculateSalaries(
                        dao.findAll()
                )
        );
    }
}

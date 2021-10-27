package manual.dependency.injection;

import commons.bls.EmployeeSalaryCalculator;
import commons.dao.EmployeeDao;
import commons.report.XlsSalaryReport;

public class Runner {
    public static void main(String[] args) {
        EmployeesSalariesReportService service  = new EmployeesSalariesReportService(
                new EmployeeDao(),
                new EmployeeSalaryCalculator(),
                new XlsSalaryReport()
        );

        service.generateReport();
    }
}

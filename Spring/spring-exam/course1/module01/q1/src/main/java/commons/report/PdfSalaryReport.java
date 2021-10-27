package commons.report;

import commons.ds.EmployeeSalary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("pdf-reports")
public class PdfSalaryReport implements SalaryReport{
    @Override
    public void writeReport(List<EmployeeSalary> employeeSalaries) {
        System.out.println("Writing PDF Report");
    }
}

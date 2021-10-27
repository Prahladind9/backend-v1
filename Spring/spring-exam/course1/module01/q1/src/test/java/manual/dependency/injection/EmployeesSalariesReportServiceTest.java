package manual.dependency.injection;

import commons.bls.EmployeeSalaryCalculator;
import commons.dao.EmployeeDao;
import commons.ds.Employee;
import commons.ds.EmployeeSalary;
import commons.report.SalaryReport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeesSalariesReportServiceTest {
    @InjectMocks
    private EmployeesSalariesReportService employeesSalariesReportService;

    @Mock
    private EmployeeDao employeeDao;
    @Mock
    private EmployeeSalaryCalculator calculator;
    @Mock
    private SalaryReport report;
    @Mock
    private List<Employee> employees;
    @Mock
    private List<EmployeeSalary> salaries;

    @Test
    public void shouldGenerateSalaryReport(){
        when(employeeDao.findAll()).thenReturn(employees);
        when(calculator.calculateSalaries(employees)).thenReturn(salaries);

        employeesSalariesReportService.generateReport();

        verify(report).writeReport(salaries);
    }
}

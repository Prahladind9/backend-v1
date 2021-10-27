package no.dependency.injection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeesSalariesReportServiceTest {

    @InjectMocks
    private EmployeesSalariesReportService employeesSalariesReportService;

    @Test
    public void shouldGenerateSalaryReport(){

    }
}

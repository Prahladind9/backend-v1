package com.spring.professional.service;

import com.spring.professional.ApplicationConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class EmployeesSalariesReportServiceTest {

    @Autowired
    private EmployeesSalariesReportService employeesSalariesReportService;

    @Test
    public void shouldGenerateReport(){
        employeesSalariesReportService.generateReport();
    }
}

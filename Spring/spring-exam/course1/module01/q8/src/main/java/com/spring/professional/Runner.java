package com.spring.professional;

import com.spring.professional.service.EmployeesSalariesReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            EmployeesSalariesReportService employeesSalariesReportService = context.getBean(EmployeesSalariesReportService.class);
            employeesSalariesReportService.generateReport();
        }
    }
}

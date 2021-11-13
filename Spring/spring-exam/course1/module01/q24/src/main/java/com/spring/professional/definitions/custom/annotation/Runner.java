package com.spring.professional.definitions.custom.annotation;

import com.spring.professional.definitions.custom.annotation.service.FinancialReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        //Active profile
        context.getEnvironment().setActiveProfiles("file");
        context.register(ApplicationConfiguration.class);
        context.refresh();

        context.getBean(FinancialReportService.class).generateReport();
    }
}

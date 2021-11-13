package com.spring.professional.definitions.bean.method.level;

import com.spring.professional.definitions.component.level.service.FinancialReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        //Activate Profile
        context.getEnvironment().setActiveProfiles("database");
        context.register(ApplicationConfiguration.class);
        context.refresh();

        context.getBean(FinancialReportService.class).generateReport();
    }
}

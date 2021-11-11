package com.spring.professional;

import com.spring.professional.service.ReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        ReportService service = context.getBean(ReportService.class);
        service.execute();
    }
}

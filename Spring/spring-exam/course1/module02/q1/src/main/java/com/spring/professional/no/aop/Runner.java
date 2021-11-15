package com.spring.professional.no.aop;

import com.spring.professional.no.aop.actions.ComplexReportAction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        ComplexReportAction complexReportAction = context.getBean(ComplexReportAction.class);
        complexReportAction.perform();
    }
}

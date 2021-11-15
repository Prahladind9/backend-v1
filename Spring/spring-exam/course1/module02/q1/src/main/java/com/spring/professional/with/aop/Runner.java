package com.spring.professional.with.aop;

import com.spring.professional.with.aop.actions.ComplexReportAction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        ComplexReportAction action = context.getBean(ComplexReportAction.class);
        action.perform();

    }
}

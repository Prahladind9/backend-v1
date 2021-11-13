package com.spring.professional.activation.programatically;

import com.spring.professional.activation.programatically.dao.FinancialDataDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        context.getEnvironment().setActiveProfiles("file");
        context.register(ApplicationConfig.class);
        context.refresh();

        System.out.println(context.getBean(FinancialDataDao.class).getClass().getSimpleName());
    }
}

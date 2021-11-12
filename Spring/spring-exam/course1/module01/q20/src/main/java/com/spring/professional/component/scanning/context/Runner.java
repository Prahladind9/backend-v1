package com.spring.professional.component.scanning.context;

import com.spring.professional.component.scanning.context.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        context.getBean(SpringBean1.class).printDependencies();
    }
}

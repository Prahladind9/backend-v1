package com.spring.professional;

import com.spring.professional.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        SpringBean1 springBean1 = context.getBean(SpringBean1.class);
        springBean1.sayHello();
    }
}

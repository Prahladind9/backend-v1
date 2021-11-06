package com.spring.professional;

import com.spring.professional.beans.SpringBean1;
import com.spring.professional.beans.SpringBean2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        System.out.println(context.getBean(SpringBean1.class));
        System.out.println(context.getBean(SpringBean1.class));
        System.out.println(context.getBean(SpringBean1.class));

        System.out.println(context.getBean(SpringBean2.class));
        System.out.println(context.getBean(SpringBean2.class));
        System.out.println(context.getBean(SpringBean2.class));
    }
}

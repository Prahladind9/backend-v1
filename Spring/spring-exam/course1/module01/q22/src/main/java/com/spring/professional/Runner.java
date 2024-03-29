package com.spring.professional;

import com.spring.professional.beans.SpringBean3;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        System.out.println("Printing Bean Names:");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        System.out.print("Fetching Bean by Alias: ");
        System.out.println(context.getBean("thirdSpringBean").getClass().getSimpleName());

    }
}

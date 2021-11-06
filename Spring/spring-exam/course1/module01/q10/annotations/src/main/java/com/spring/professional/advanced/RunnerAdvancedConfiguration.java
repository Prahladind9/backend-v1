package com.spring.professional.advanced;

import com.spring.professional.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class RunnerAdvancedConfiguration {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}

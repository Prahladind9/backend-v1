package com.spring.professional.exam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class ApplicationConfiguration {
    @Bean
    public static CustomBeanFactoryPostProcessor getCustomBeanFactoryPostProcessor(){
        return new CustomBeanFactoryPostProcessor();
    }

    @Bean
    public static CustomBeanPostProcessor getCustomBeanPostProcessor(){
        return new CustomBeanPostProcessor();
    }
}

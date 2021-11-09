package com.spring.professional;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@PropertySource("classpath:/app-defaults.properties")
public class ApplicationConfiguration {
    @Bean
    public static BeanFactoryPostProcessor customBeanFactoryPostProcessor(){
        return new CustomBeanFactoryPostProcessor();
    }
}

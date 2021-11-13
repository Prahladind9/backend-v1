package com.spring.professional;

import com.spring.professional.beans.mapper.DataMapper;
import com.spring.professional.beans.processor.DataProcessor;
import com.spring.professional.beans.readers.DataReader;
import com.spring.professional.beans.writer.DataWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        //Activate profile
        context.getEnvironment().setActiveProfiles("database", "prod");
        context.register(ApplicationConfig.class);
        context.refresh();

        System.out.println(context.getBean(DataMapper.class).getClass().getSimpleName());
        System.out.println(context.getBean(DataProcessor.class).getClass().getSimpleName());
        System.out.println(context.getBean(DataReader.class).getClass().getSimpleName());
        System.out.println(context.getBean(DataWriter.class).getClass().getSimpleName());
    }
}

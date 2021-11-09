package com.spring.professional;

import com.spring.professional.beans.PropertyReadingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        PropertyReadingBean bean = context.getBean(PropertyReadingBean.class);
        bean.printProperties();
    }
}

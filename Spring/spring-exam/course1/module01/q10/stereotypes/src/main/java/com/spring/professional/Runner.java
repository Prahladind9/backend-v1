package com.spring.professional;

import com.spring.professional.controller.TaxInformationController;
import com.spring.professional.ds.Article;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        TaxInformationController taxInformationController = context.getBean(TaxInformationController.class);
        taxInformationController.printTaxInformation(new Article(5));
    }
}

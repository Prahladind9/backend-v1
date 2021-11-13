package com.spring.professional.activation.spring.boot.programatically;

import com.spring.professional.activation.spring.boot.programatically.dao.FinancialDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Runner implements CommandLineRunner {

    @Autowired
    private FinancialDataDao financialDataDao;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(financialDataDao.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Runner.class)
                .profiles("file")
                .run(args);
    }
}

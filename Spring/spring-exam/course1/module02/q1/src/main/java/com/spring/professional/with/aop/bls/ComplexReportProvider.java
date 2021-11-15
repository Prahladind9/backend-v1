package com.spring.professional.with.aop.bls;

import com.spring.professional.with.aop.ds.Report;
import com.spring.professional.with.aop.annotations.Cacheable;
import com.spring.professional.with.aop.annotations.PerformanceLogger;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ComplexReportProvider {

    @PerformanceLogger
    @Cacheable
    public Report getReport() throws InterruptedException{
        System.out.println("Fetching the report...");
        Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        System.out.println("Report created");

        return new Report();
    }
}

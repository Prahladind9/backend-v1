package com.spring.professional.with.aop.bls;

import com.spring.professional.with.aop.ds.Report;
import com.spring.professional.with.aop.annotations.PerformanceLogger;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ComplexReportRepository {

    @PerformanceLogger
    public void save(Report report) throws InterruptedException{
        System.out.println("Saving the report...");
        Thread.sleep(TimeUnit.SECONDS.toMillis(2));
        System.out.println("Report saved");
    }
}

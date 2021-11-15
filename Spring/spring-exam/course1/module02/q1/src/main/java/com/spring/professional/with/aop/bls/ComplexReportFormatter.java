package com.spring.professional.with.aop.bls;

import com.spring.professional.with.aop.ds.FormattedReport;
import com.spring.professional.with.aop.ds.Report;
import com.spring.professional.with.aop.annotations.PerformanceLogger;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ComplexReportFormatter {

    @PerformanceLogger
    public FormattedReport formattedReport(Report report) throws InterruptedException{
        System.out.println("Formatting the report ...");
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("Report Formatted");

        return new FormattedReport(report);
    }
}

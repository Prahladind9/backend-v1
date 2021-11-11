package com.spring.professional.writer;

import com.spring.professional.ds.Report;
import org.springframework.stereotype.Component;

@Component
public class DbReportWriter implements ReportWriter{

    @Override
    public void write(Report report, String reportName) {
        System.out.println(report.getClass().getSimpleName() + "::globalName::" + reportName);
    }

}

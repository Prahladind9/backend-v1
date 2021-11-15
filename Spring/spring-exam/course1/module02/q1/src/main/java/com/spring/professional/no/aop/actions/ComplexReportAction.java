package com.spring.professional.no.aop.actions;

import com.spring.professional.no.aop.bls.ComplexReportFormatter;
import com.spring.professional.no.aop.bls.ComplexReportProvider;
import com.spring.professional.no.aop.bls.ComplexReportRepository;
import com.spring.professional.no.aop.ds.FormattedReport;
import com.spring.professional.no.aop.ds.Report;
import com.spring.professional.no.aop.logger.PerformanceLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComplexReportAction {
    @Autowired
    private ComplexReportProvider complexReportProvider;
    @Autowired
    private ComplexReportFormatter complexReportFormatter;
    @Autowired
    private ComplexReportRepository complexReportRepository;
    @Autowired
    private PerformanceLogger logger;

    public void perform() throws InterruptedException{
        PerformanceLogger.PerformanceLoggerInfo performanceLoggerInfo;

        performanceLoggerInfo = logger.start("complexReportProvider.getReport");
        Report report = complexReportProvider.getReport();
        logger.stop(performanceLoggerInfo);

        performanceLoggerInfo = logger.start("complexReportFormatter.formattedReport");
        FormattedReport formattedReport = complexReportFormatter.formattedReport(report);
        logger.stop(performanceLoggerInfo);

        performanceLoggerInfo = logger.start("complexReportRepository.save");
        complexReportRepository.save(formattedReport);
        logger.stop(performanceLoggerInfo);

        performanceLoggerInfo = logger.start("complexReportProvider.getReport");
        report = complexReportProvider.getReport();
        logger.stop(performanceLoggerInfo);
    }
}

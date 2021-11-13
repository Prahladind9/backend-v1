package com.spring.professional.definitions.configuration.level.service;

import com.spring.professional.definitions.configuration.level.dao.FinancialDataDao;
import com.spring.professional.definitions.configuration.level.writer.FinancialReportWriter;
import org.springframework.stereotype.Component;

@Component
public class FinancialReportService {
    private final FinancialDataDao financialDataDao;
    private final FinancialReportWriter financialReportWriter;

    public FinancialReportService(FinancialDataDao financialDataDao, FinancialReportWriter financialReportWriter) {
        this.financialDataDao = financialDataDao;
        this.financialReportWriter = financialReportWriter;
    }

    public void generateReport(){

        financialReportWriter.appendFreeText("Year / Quarter / Month Financial Report");
        financialReportWriter.appendFinancialYearSummary(
                financialDataDao.findFinancialYearlySummary(2021));
        financialReportWriter.appendFinancialQuarterSummary(
                financialDataDao.findFinancialQuarterlySummary(2021, 1));
        financialReportWriter.appendFinancialMonthlySummary(
                financialDataDao.findFinancialMonthlySummary(2021, 3));
    }
}

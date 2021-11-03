package com.spring.professional.exam.service;

import com.spring.professional.exam.dao.FinancialDataDao;
import com.spring.professional.exam.ds.FinancialYearlySummary;
import com.spring.professional.exam.writer.FinancialReportWriter;

public class SimpleFinancialReportService {
    private final FinancialDataDao financialDataDao;
    private final FinancialReportWriter financialReportWriter;

    SimpleFinancialReportService(FinancialDataDao financialDataDao, FinancialReportWriter financialReportWriter) {
        this.financialDataDao = financialDataDao;
        this.financialReportWriter = financialReportWriter;
    }

    void generateReport(){
        FinancialYearlySummary financialYearlySummary = financialDataDao.findFinancialYearlySummary(2021);
        financialReportWriter.appendFinancialYearSummary(financialYearlySummary);
    }
}

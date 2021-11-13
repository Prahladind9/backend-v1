package com.spring.professional.definitions.configuration.level.writer;

import com.spring.professional.definitions.configuration.level.ds.FinancialMonthSummary;
import com.spring.professional.definitions.configuration.level.ds.FinancialQuarterlySummary;
import com.spring.professional.definitions.configuration.level.ds.FinancialYearlySummary;
import org.springframework.stereotype.Component;

@Component
public class FileStoreFinancialReportWriter implements FinancialReportWriter {
    @Override
    public void appendFreeText(String title) {
        System.out.println("File Writer => appendFreeText");
    }

    @Override
    public void appendFinancialYearSummary(FinancialYearlySummary financialYearlySummary) {
        System.out.println("File Writer => appendFinancialYearSummary");
    }

    @Override
    public void appendFinancialQuarterSummary(FinancialQuarterlySummary financialQuarterlySummary) {
        System.out.println("File Writer => appendFinancialQuarterSummary");
    }

    @Override
    public void appendFinancialMonthlySummary(FinancialMonthSummary financialMonthSummary) {
        System.out.println("File Writer => appendFinancialMonthlySummary");
    }
}

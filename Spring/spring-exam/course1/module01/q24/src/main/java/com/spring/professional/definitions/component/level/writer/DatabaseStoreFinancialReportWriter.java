package com.spring.professional.definitions.component.level.writer;

import com.spring.professional.definitions.component.level.ds.FinancialMonthSummary;
import com.spring.professional.definitions.component.level.ds.FinancialQuarterlySummary;
import com.spring.professional.definitions.component.level.ds.FinancialYearlySummary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("database")
public class DatabaseStoreFinancialReportWriter implements FinancialReportWriter{
    @Override
    public void appendFreeText(String title) {
        System.out.println("Database Writer => appendFreeText");
    }

    @Override
    public void appendFinancialYearSummary(FinancialYearlySummary financialYearlySummary) {
        System.out.println("Database Writer => appendFinancialYearSummary");
    }

    @Override
    public void appendFinancialQuarterSummary(FinancialQuarterlySummary financialQuarterlySummary) {
        System.out.println("Database Writer => appendFinancialQuarterSummary");
    }

    @Override
    public void appendFinancialMonthlySummary(FinancialMonthSummary financialMonthSummary) {
        System.out.println("Database Writer => appendFinancialMonthlySummary");
    }
}

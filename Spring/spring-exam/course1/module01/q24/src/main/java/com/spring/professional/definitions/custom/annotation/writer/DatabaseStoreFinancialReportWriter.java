package com.spring.professional.definitions.custom.annotation.writer;

import com.spring.professional.definitions.custom.annotation.annotation.DatabaseProfile;
import com.spring.professional.definitions.custom.annotation.ds.FinancialMonthSummary;
import com.spring.professional.definitions.custom.annotation.ds.FinancialQuarterlySummary;
import com.spring.professional.definitions.custom.annotation.ds.FinancialYearlySummary;
import org.springframework.stereotype.Component;

@Component
@DatabaseProfile
public class DatabaseStoreFinancialReportWriter implements FinancialReportWriter {
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

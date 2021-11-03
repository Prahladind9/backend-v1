package com.spring.professional.exam.writer;

import com.spring.professional.exam.ds.FinancialMonthSummary;
import com.spring.professional.exam.ds.FinancialQuarterlySummary;
import com.spring.professional.exam.ds.FinancialYearlySummary;

public class MockFinancialReportWriter implements FinancialReportWriter{
    @Override
    public void appendFreeText(String title) {
        System.out.println("Mock Writer => appendFreeText");
    }

    @Override
    public void appendFinancialYearSummary(FinancialYearlySummary financialYearlySummary) {
        System.out.println("Mock Writer => appendFinancialYearSummary");
    }

    @Override
    public void appendFinancialQuarterSummary(FinancialQuarterlySummary financialQuarterlySummary) {
        System.out.println("Mock Writer => appendFinancialQuarterSummary");
    }

    @Override
    public void appendFinancialMonthlySummary(FinancialMonthSummary financialMonthSummary) {
        System.out.println("Mock Writer => appendFinancialMonthlySummary");
    }
}

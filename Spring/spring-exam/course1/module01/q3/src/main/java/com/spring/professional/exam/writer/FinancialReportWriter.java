package com.spring.professional.exam.writer;

import com.spring.professional.exam.ds.FinancialMonthSummary;
import com.spring.professional.exam.ds.FinancialQuarterlySummary;
import com.spring.professional.exam.ds.FinancialYearlySummary;

public interface FinancialReportWriter {

    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearlySummary financialYearlySummary);
    void appendFinancialQuarterSummary(FinancialQuarterlySummary financialQuarterlySummary);
    void appendFinancialMonthlySummary(FinancialMonthSummary financialMonthSummary);
}

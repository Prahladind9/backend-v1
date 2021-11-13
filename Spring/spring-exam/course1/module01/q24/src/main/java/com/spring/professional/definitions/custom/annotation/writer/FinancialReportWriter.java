package com.spring.professional.definitions.custom.annotation.writer;

import com.spring.professional.definitions.custom.annotation.ds.FinancialMonthSummary;
import com.spring.professional.definitions.custom.annotation.ds.FinancialQuarterlySummary;
import com.spring.professional.definitions.custom.annotation.ds.FinancialYearlySummary;

public interface FinancialReportWriter {

    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearlySummary financialYearlySummary);
    void appendFinancialQuarterSummary(FinancialQuarterlySummary financialQuarterlySummary);
    void appendFinancialMonthlySummary(FinancialMonthSummary financialMonthSummary);
}

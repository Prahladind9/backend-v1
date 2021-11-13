package com.spring.professional.definitions.configuration.level.writer;

import com.spring.professional.definitions.configuration.level.ds.FinancialMonthSummary;
import com.spring.professional.definitions.configuration.level.ds.FinancialQuarterlySummary;
import com.spring.professional.definitions.configuration.level.ds.FinancialYearlySummary;

public interface FinancialReportWriter {

    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearlySummary financialYearlySummary);
    void appendFinancialQuarterSummary(FinancialQuarterlySummary financialQuarterlySummary);
    void appendFinancialMonthlySummary(FinancialMonthSummary financialMonthSummary);
}

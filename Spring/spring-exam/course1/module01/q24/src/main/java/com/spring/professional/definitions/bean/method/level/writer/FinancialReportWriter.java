package com.spring.professional.definitions.bean.method.level.writer;

import com.spring.professional.definitions.bean.method.level.ds.FinancialMonthSummary;
import com.spring.professional.definitions.bean.method.level.ds.FinancialQuarterlySummary;
import com.spring.professional.definitions.bean.method.level.ds.FinancialYearlySummary;

public interface FinancialReportWriter {

    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearlySummary financialYearlySummary);
    void appendFinancialQuarterSummary(FinancialQuarterlySummary financialQuarterlySummary);
    void appendFinancialMonthlySummary(FinancialMonthSummary financialMonthSummary);
}

package com.spring.professional.exam.dao;

import com.spring.professional.exam.ds.FinancialMonthSummary;
import com.spring.professional.exam.ds.FinancialQuarterlySummary;
import com.spring.professional.exam.ds.FinancialYearlySummary;

public interface FinancialDataDao {
    FinancialYearlySummary findFinancialYearlySummary(int year);

    FinancialQuarterlySummary findFinancialQuarterlySummary(int year, int quarter);

    FinancialMonthSummary findFinancialMonthlySummary(int year, int month);
}

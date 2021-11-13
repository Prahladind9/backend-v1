package com.spring.professional.definitions.custom.annotation.dao;


import com.spring.professional.definitions.custom.annotation.ds.FinancialMonthSummary;
import com.spring.professional.definitions.custom.annotation.ds.FinancialQuarterlySummary;
import com.spring.professional.definitions.custom.annotation.ds.FinancialYearlySummary;

public interface FinancialDataDao {
    FinancialYearlySummary findFinancialYearlySummary(int year);

    FinancialQuarterlySummary findFinancialQuarterlySummary(int year, int quarter);

    FinancialMonthSummary findFinancialMonthlySummary(int year, int month);
}

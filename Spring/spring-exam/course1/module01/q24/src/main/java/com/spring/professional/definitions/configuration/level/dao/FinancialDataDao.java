package com.spring.professional.definitions.configuration.level.dao;


import com.spring.professional.definitions.configuration.level.ds.FinancialMonthSummary;
import com.spring.professional.definitions.configuration.level.ds.FinancialQuarterlySummary;
import com.spring.professional.definitions.configuration.level.ds.FinancialYearlySummary;

public interface FinancialDataDao {
    FinancialYearlySummary findFinancialYearlySummary(int year);

    FinancialQuarterlySummary findFinancialQuarterlySummary(int year, int quarter);

    FinancialMonthSummary findFinancialMonthlySummary(int year, int month);
}

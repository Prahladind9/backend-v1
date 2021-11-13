package com.spring.professional.definitions.bean.method.level.dao;


import com.spring.professional.definitions.bean.method.level.ds.FinancialMonthSummary;
import com.spring.professional.definitions.bean.method.level.ds.FinancialQuarterlySummary;
import com.spring.professional.definitions.bean.method.level.ds.FinancialYearlySummary;

public interface FinancialDataDao {
    FinancialYearlySummary findFinancialYearlySummary(int year);

    FinancialQuarterlySummary findFinancialQuarterlySummary(int year, int quarter);

    FinancialMonthSummary findFinancialMonthlySummary(int year, int month);
}

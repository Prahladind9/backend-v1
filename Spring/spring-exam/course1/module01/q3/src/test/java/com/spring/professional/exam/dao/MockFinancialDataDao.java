package com.spring.professional.exam.dao;

import com.spring.professional.exam.ds.FinancialMonthSummary;
import com.spring.professional.exam.ds.FinancialQuarterlySummary;
import com.spring.professional.exam.ds.FinancialYearlySummary;

public class MockFinancialDataDao implements FinancialDataDao{

    @Override
    public FinancialYearlySummary findFinancialYearlySummary(int year) {
        System.out.println("Mock Dao => findFinancialYearlySummary");
        return new FinancialYearlySummary();
    }

    @Override
    public FinancialQuarterlySummary findFinancialQuarterlySummary(int year, int quarter) {
        System.out.println("Mock Dao => findFinancialQuarterlySummary");
        return new FinancialQuarterlySummary();
    }

    @Override
    public FinancialMonthSummary findFinancialMonthlySummary(int year, int month) {
        System.out.println("Mock Dao => findFinancialMonthlySummary");
        return new FinancialMonthSummary();
    }
}

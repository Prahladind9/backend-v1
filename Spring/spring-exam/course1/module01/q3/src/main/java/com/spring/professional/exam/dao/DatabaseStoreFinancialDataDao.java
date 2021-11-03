package com.spring.professional.exam.dao;

import com.spring.professional.exam.ds.FinancialMonthSummary;
import com.spring.professional.exam.ds.FinancialQuarterlySummary;
import com.spring.professional.exam.ds.FinancialYearlySummary;
import org.springframework.stereotype.Component;

@Component("database-dao")
public class DatabaseStoreFinancialDataDao implements FinancialDataDao{
    @Override
    public FinancialYearlySummary findFinancialYearlySummary(int year) {
        System.out.println("Database Dao => findFinancialYearlySummary");
        return new FinancialYearlySummary();
    }

    @Override
    public FinancialQuarterlySummary findFinancialQuarterlySummary(int year, int quarter) {
        System.out.println("Database Dao => findFinancialQuarterlySummary");
        return new FinancialQuarterlySummary();
    }

    @Override
    public FinancialMonthSummary findFinancialMonthlySummary(int year, int month) {
        System.out.println("Database Dao => findFinancialMonthlySummary");
        return new FinancialMonthSummary();
    }
}

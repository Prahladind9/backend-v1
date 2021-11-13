package com.spring.professional.definitions.component.level.dao;


import com.spring.professional.definitions.component.level.ds.FinancialMonthSummary;
import com.spring.professional.definitions.component.level.ds.FinancialQuarterlySummary;
import com.spring.professional.definitions.component.level.ds.FinancialYearlySummary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("database")
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

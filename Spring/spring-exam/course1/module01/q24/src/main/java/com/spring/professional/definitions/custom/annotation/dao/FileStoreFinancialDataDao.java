package com.spring.professional.definitions.custom.annotation.dao;

import com.spring.professional.definitions.custom.annotation.annotation.FileProfile;
import com.spring.professional.definitions.custom.annotation.ds.FinancialMonthSummary;
import com.spring.professional.definitions.custom.annotation.ds.FinancialQuarterlySummary;
import com.spring.professional.definitions.custom.annotation.ds.FinancialYearlySummary;
import org.springframework.stereotype.Component;

@Component
@FileProfile
public class FileStoreFinancialDataDao implements FinancialDataDao {
    @Override
    public FinancialYearlySummary findFinancialYearlySummary(int year) {
        System.out.println("File Dao => findFinancialYearlySummary");
        return null;
    }

    @Override
    public FinancialQuarterlySummary findFinancialQuarterlySummary(int year, int quarter) {
        System.out.println("File Dao => findFinancialQuarterlySummary");
        return new FinancialQuarterlySummary();
    }

    @Override
    public FinancialMonthSummary findFinancialMonthlySummary(int year, int month) {
        System.out.println("File Dao => findFinancialMonthlySummary");
        return new FinancialMonthSummary();
    }
}

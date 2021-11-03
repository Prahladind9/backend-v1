package com.spring.professional.exam.dao;

import com.spring.professional.exam.ds.FinancialYearlySummary;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class DatabaseStoreFinancialDataDaoTest {

    @Test
    public void shouldCreateFinancialDataDao(){
        FinancialDataDao financialDataDao = new DatabaseStoreFinancialDataDao();
        FinancialYearlySummary financialYearlySummary = financialDataDao.findFinancialYearlySummary(2021);

        assertNotNull(financialYearlySummary);
    }
}

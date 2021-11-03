package com.spring.professional.exam.service;

import com.spring.professional.exam.dao.MockFinancialDataDao;
import com.spring.professional.exam.writer.MockFinancialReportWriter;
import org.junit.Test;

public class SimpleFinancialReportServiceTest {

    @Test
    public void shouldGenerateReportOnManualMockTypes(){
        SimpleFinancialReportService simpleFinancialReportService
                = new SimpleFinancialReportService(
                        new MockFinancialDataDao(), new MockFinancialReportWriter()
        );

        simpleFinancialReportService.generateReport();
    }
}

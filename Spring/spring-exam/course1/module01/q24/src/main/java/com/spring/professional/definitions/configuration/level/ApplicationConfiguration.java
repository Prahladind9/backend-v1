package com.spring.professional.definitions.configuration.level;

import com.spring.professional.definitions.component.level.dao.FinancialDataDao;
import com.spring.professional.definitions.component.level.service.FinancialReportService;
import com.spring.professional.definitions.component.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DatabaseApplicationConfiguration.class, FileApplicationConfiguration.class})
public class ApplicationConfiguration {

    @Bean
    public FinancialReportService financialReportService(FinancialDataDao financialDataDao, FinancialReportWriter financialReportWriter){
        return new FinancialReportService(financialDataDao, financialReportWriter);
    }
}

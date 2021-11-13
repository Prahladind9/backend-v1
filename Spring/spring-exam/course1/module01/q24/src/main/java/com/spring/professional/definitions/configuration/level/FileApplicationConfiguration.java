package com.spring.professional.definitions.configuration.level;

import com.spring.professional.definitions.component.level.dao.FileStoreFinancialDataDao;
import com.spring.professional.definitions.component.level.dao.FinancialDataDao;
import com.spring.professional.definitions.component.level.writer.FileStoreFinancialReportWriter;
import com.spring.professional.definitions.component.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("file")
public class FileApplicationConfiguration {
    @Bean
    public FinancialDataDao fileFinancialDataDao(){
        return new FileStoreFinancialDataDao();
    }

    @Bean
    public FinancialReportWriter FileFinancialReportWriter(){
        return new FileStoreFinancialReportWriter();
    }
}

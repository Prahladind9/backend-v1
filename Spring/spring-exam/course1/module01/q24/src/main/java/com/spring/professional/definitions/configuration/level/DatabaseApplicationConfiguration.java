package com.spring.professional.definitions.configuration.level;

import com.spring.professional.definitions.component.level.dao.DatabaseStoreFinancialDataDao;
import com.spring.professional.definitions.component.level.dao.FinancialDataDao;
import com.spring.professional.definitions.component.level.writer.DatabaseStoreFinancialReportWriter;
import com.spring.professional.definitions.component.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("database")
public class DatabaseApplicationConfiguration {
    @Bean
    public FinancialDataDao databaseFinancialDataDao(){
        return new DatabaseStoreFinancialDataDao();
    }

    @Bean
    public FinancialReportWriter databaseFinancialReportWriter(){
        return new DatabaseStoreFinancialReportWriter();
    }
}

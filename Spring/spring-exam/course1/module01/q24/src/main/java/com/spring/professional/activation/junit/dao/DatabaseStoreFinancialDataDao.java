package com.spring.professional.activation.junit.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("database")
public class DatabaseStoreFinancialDataDao implements FinancialDataDao {
}

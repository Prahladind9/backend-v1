package com.spring.professional;

import com.spring.professional.beans.mapper.DataMapper;
import com.spring.professional.beans.processor.DataProcessor;
import com.spring.professional.beans.processor.MultiSourceDataProcessor;
import com.spring.professional.beans.readers.DataReader;
import com.spring.professional.beans.readers.DbDataReader;
import com.spring.professional.beans.readers.FileDataReader;
import com.spring.professional.beans.writer.DataWriter;
import com.spring.professional.beans.writer.DevDataWriter;
import com.spring.professional.beans.writer.ProdDataWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig {
    @Bean
    public DataMapper dataMapper(){
        return new DataMapper();
    }

    @Bean
    @Profile({"database", "file"})
    public DataProcessor multiSourceDataProcessor(){
        return new MultiSourceDataProcessor();
    }

    @Bean
    @Profile("database")
    public DataReader dbDataReader(){
        return new DbDataReader();
    }

    @Bean
    @Profile("file")
    public DataReader fileDataReader(){
        return new FileDataReader();
    }

    @Bean
    @Profile("!prod")
    public DataWriter devDataWriter(){
        return new DevDataWriter();
    }

    @Bean
    @Profile("!dev")
    public DataWriter prodDataWriter(){
        return new ProdDataWriter();
    }
}

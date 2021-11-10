package com.spring.professional.service;

import com.spring.professional.non.beans.RecordsValidator;
import com.spring.professional.reader.DbRecordsReader;
import com.spring.professional.reader.RecordsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordsService4 {

    @Autowired
    public void setRecordsReader(DbRecordsReader dbRecordsReader){
        System.out.println(getClass().getSimpleName() + " setRecordsReader:" + dbRecordsReader);
    }

    @Autowired(required = false)
    public void setRecordsReaderAndRecordsValidator(RecordsReader recordsReader, RecordsValidator recordsValidator){
        System.out.println(getClass().getSimpleName() + " setRecordsReaderAndRecordsValidator" +
                "\t recordsReader" + recordsReader +
                "\t recordsValidator" + recordsValidator
        );
    }
}
